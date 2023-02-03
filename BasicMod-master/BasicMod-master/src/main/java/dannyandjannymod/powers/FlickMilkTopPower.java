//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package dannyandjannymod.powers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.megacrit.cardcrawl.actions.AbstractGameAction.AttackEffect;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.cards.DamageInfo.DamageType;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.AbstractPower.PowerType;
import dannyandjannymod.cards.FlickMilkTopCard;
import dannyandjannymod.util.TextureLoader;

public class FlickMilkTopPower extends AbstractPower {
    public static final String POWER_ID = "FlickMilkTopPower";
    public static final String NAME;
    public static final String[] DESCRIPTIONS;

    public FlickMilkTopPower(AbstractCreature owner) {
        this.name = NAME;
        this.ID = "FlickMilkTopPower";
        this.owner = owner;
        this.amount = 1;
        this.type = PowerType.DEBUFF;
        this.updateDescription();
        this.loadRegion("cExplosion");

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

    public void onDeath() {
        if (!AbstractDungeon.getMonsters().areMonstersBasicallyDead() &&
            this.owner.currentHealth <= 0) {
            for (int i = 0; i < this.amount; i++) {
                AbstractCard c = new FlickMilkTopCard();
                addToBot(new MakeTempCardInHandAction(c));
            }
        }
    }

    public void updateDescription() {
        this.description = DESCRIPTIONS[0] + this.amount + (this.amount == 1 ? DESCRIPTIONS[1] : DESCRIPTIONS[2]);
    }

    static {
        NAME = "Milk Top";
        DESCRIPTIONS = new String[]{"When this monster dies, add #b", " Flick Milk Top card to your hand.", " Flick Milk Top cards to your hand."};
    }
}
