package dannyandjannymod.powers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;
import dannyandjannymod.CardWithTagGenerationAction;
import dannyandjannymod.CustomTags;
import dannyandjannymod.util.TextureLoader;

public class DeliverancePower extends AbstractPower {
    public static final String POWER_ID = "DeliverancePower";
    public static final String NAME;
    public static final String[] DESCRIPTIONS;

    public DeliverancePower(AbstractCreature owner, int stackAmount) {
        this.name = NAME;
        this.ID = "DeliverancePower";
        this.owner = owner;
        this.amount = stackAmount;
        this.type = PowerType.DEBUFF;
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

    public int onAttacked(DamageInfo info, int damageAmount) {
        if (!AbstractDungeon.getMonsters().areMonstersBasicallyDead() && this.amount > 0 && info.type == DamageInfo.DamageType.NORMAL) {
            this.flash();
            this.addToBot(new DrawCardAction(AbstractDungeon.player, 1));
            this.addToTop(new ReducePowerAction(this.owner, this.owner, "DeliverancePower", 1));
        }

        return damageAmount;
    }

    public void stackPower(int stackAmount) {
        this.fontScale = 8.0F;
        this.amount += stackAmount;
    }

    public void updateDescription() {
        this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
    }

    static {
        //powerStrings = CardCrawlGame.languagePack.getPowerStrings("Magnetism");
        //NAME = powerStrings.NAME;
        NAME = "Deliverance";
        //SINGULAR_DESCRIPTION = powerStrings.DESCRIPTIONS[0];
        DESCRIPTIONS = new String[] {"The next #b", " times you attack this enemy, draw #b1 card."} ;
    }
}