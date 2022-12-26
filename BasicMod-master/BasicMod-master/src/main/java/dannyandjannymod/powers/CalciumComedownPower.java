package dannyandjannymod.powers;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.*;

public class CalciumComedownPower extends AbstractPower {
    public static final String POWER_ID = "CalciumComedownPower";
    private static final PowerStrings powerStrings;
    public static final String NAME;
    public static final String[] DESCRIPTIONS;

    public CalciumComedownPower(AbstractCreature owner, int newAmount) {
        this.name = NAME;
        this.ID = "CalciumComedownPower";
        this.owner = owner;
        this.amount = newAmount;
        this.type = PowerType.DEBUFF;
        this.updateDescription();
        this.loadRegion("flex");
        if (this.amount >= 999) {
            this.amount = 999;
        }

        if (this.amount <= -999) {
            this.amount = -999;
        }

    }

    public void playApplyPowerSfx() {
        CardCrawlGame.sound.play("POWER_SHACKLE", 0.05F);
    }

    public void stackPower(int stackAmount) {
        this.fontScale = 8.0F;
        this.amount += stackAmount;
        if (this.amount == 0) {
            this.addToTop(new RemoveSpecificPowerAction(this.owner, this.owner, "Shackled"));
        }

        if (this.amount >= 999) {
            this.amount = 999;
        }

        if (this.amount <= -999) {
            this.amount = -999;
        }

    }

    public void reducePower(int reduceAmount) {
        this.fontScale = 8.0F;
        this.amount -= reduceAmount;
        if (this.amount == 0) {
            this.addToTop(new RemoveSpecificPowerAction(this.owner, this.owner, NAME));
        }

        if (this.amount >= 999) {
            this.amount = 999;
        }

        if (this.amount <= -999) {
            this.amount = -999;
        }

    }

    public void updateDescription() {
        this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
    }

    public void atEndOfTurn(boolean isPlayer) {
        this.flash();
        this.addToBot(new ApplyPowerAction(this.owner, this.owner, new StrengthPower(this.owner, -this.amount), -this.amount));
        this.addToBot(new ApplyPowerAction(this.owner, this.owner, new DexterityPower(this.owner, -this.amount), -this.amount));
        this.addToBot(new RemoveSpecificPowerAction(this.owner, this.owner, "CalciumComedownPower"));
    }

    static {
        powerStrings = CardCrawlGame.languagePack.getPowerStrings("CalciumComedownPower");
        //NAME = powerStrings.NAME;
        //DESCRIPTIONS = powerStrings.DESCRIPTIONS;
        NAME = "Calcium Comedown";
        DESCRIPTIONS = new String[] {"Lose ", " Strength and Dexterity at the end of the turn."} ;
    }
}