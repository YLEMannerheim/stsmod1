package dannyandjannymod.powers;

import basemod.helpers.dynamicvariables.MagicNumberVariable;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.actions.unique.LoseEnergyAction;
import com.megacrit.cardcrawl.cards.tempCards.Shiv;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;
import dannyandjannymod.cards.ChugCard;
import dannyandjannymod.util.TextureLoader;

public class DrainedPower extends AbstractPower {
    public static final String POWER_ID = "DrainedPower";
    public static final String NAME;

    public DrainedPower(AbstractCreature owner, int drainedAmt) {
        this.name = NAME;
        this.ID = "DrainedPower";
        this.owner = owner;
        this.amount = drainedAmt;
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

    public void atStartOfTurn() {
        if (!AbstractDungeon.getMonsters().areMonstersBasicallyDead()) {
            this.flash();
            this.addToBot(new LoseEnergyAction(1));
            if (this.amount <= 1) {
                this.addToBot(new RemoveSpecificPowerAction(this.owner, this.owner, DrainedPower.POWER_ID));
            } else {
                this.addToBot(new ReducePowerAction(this.owner, this.owner, DrainedPower.POWER_ID, 1));
            }
        }

    }

    public void stackPower(int stackAmount) {
        this.fontScale = 8.0F;
        this.amount += stackAmount;
    }

    public void updateDescription() {
        if (this.amount > 1) {
            this.description = "Lose 1 energy for the next " + this.amount + " turns.";
        } else {
            this.description = "Lose 1 energy next turn.";
        }

    }

    static {
        NAME = "Drained";
    }
}