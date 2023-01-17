package dannyandjannymod.powers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.megacrit.cardcrawl.actions.unique.ArmamentsAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardQueueItem;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import dannyandjannymod.CustomTags;
import dannyandjannymod.util.TextureLoader;

public class CremeDeLaCremePower extends AbstractPower {

    public static final String NAME;
    public static final String[] DESCRIPTIONS;
    public CremeDeLaCremePower() {
        this.name = NAME;
        this.ID = "CremeDeLaCremePower";
        this.owner = AbstractDungeon.player;
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
        if (card.hasTag(CustomTags.MILK)) {
            this.flash();
            AbstractMonster m = null;
            addToTop(new ArmamentsAction(true));
        }

    }

    public void updateDescription() {
        this.description = DESCRIPTIONS[0];
    }

    static {
        NAME = "Crème de la Crème";
        DESCRIPTIONS = new String[]{"Whenever you play a #yMilk card, upgrade ALL cards in your hand for the rest of this combat."};
    }
}