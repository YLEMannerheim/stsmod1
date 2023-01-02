package dannyandjannymod.powers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardQueueItem;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import dannyandjannymod.CustomTags;
import dannyandjannymod.util.TextureLoader;

import static dannyandjannymod.BasicMod.makeID;

public class SpareBucketPower extends AbstractPower {

    public static final String NAME;
    public static final String SINGULAR_DESCRIPTION;
    public static final String PLURAL_DESCRIPTION;
    public SpareBucketPower(int amount) {
        this.name = NAME;
        this.ID = "SpareBucketPower";
        this.owner = AbstractDungeon.player;
        this.amount = amount;
        this.updateDescription();
        this.loadRegion("confusion");

        String unPrefixed = ID;
        Texture normalTexture = TextureLoader.getPowerTexture(unPrefixed);
        Texture hiDefImage = TextureLoader.getHiDefPowerTexture(unPrefixed);
        if (hiDefImage != null)
        {
            region128 = new TextureAtlas.AtlasRegion(hiDefImage, 0, 0, hiDefImage.getWidth(), hiDefImage.getHeight());
            if (normalTexture != null)
                region48 = new TextureAtlas.AtlasRegion(normalTexture, 0, 0, normalTexture.getWidth(), normalTexture.getHeight());
        }
        else if (normalTexture != null)
        {
            this.img = normalTexture;
            region48 = new TextureAtlas.AtlasRegion(normalTexture, 0, 0, normalTexture.getWidth(), normalTexture.getHeight());
        }
    }

    public void onUseCard(AbstractCard card, UseCardAction action) {
        for (int i = 0; i < amount; i++) {
            if (!card.purgeOnUse && card.hasTag(CustomTags.BUCKET)) {
                this.flash();
                AbstractMonster m = null;
                if (action.target != null) {
                    m = (AbstractMonster)action.target;
                }

                AbstractCard tmp = card.makeSameInstanceOf();
                AbstractDungeon.player.limbo.addToBottom(tmp);
                tmp.current_x = card.current_x;
                tmp.current_y = card.current_y;
                tmp.target_x = (float)Settings.WIDTH / 2.0F - 300.0F * Settings.scale;
                tmp.target_y = (float)Settings.HEIGHT / 2.0F;
                if (m != null) {
                    tmp.calculateCardDamage(m);
                }

                tmp.purgeOnUse = true;
                AbstractDungeon.actionManager.addCardQueueItem(new CardQueueItem(tmp, m, card.energyOnUse, true, true), true);
            }
        }
    }

    public void updateDescription() {
        if (this.amount > 1) {
            this.description = String.format(PLURAL_DESCRIPTION, this.amount);
        } else {
            this.description = String.format(SINGULAR_DESCRIPTION, this.amount);
        }

    }

    static {
        NAME = "Spare Bucket";
        SINGULAR_DESCRIPTION = "Bucket cards are played #b%d additional time.";
        PLURAL_DESCRIPTION = "Bucket cards are played #b%d additional times.";
    }
}