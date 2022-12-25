package dannyandjannymod.powers;

import com.megacrit.cardcrawl.actions.common.*;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.*;
import dannyandjannymod.CardWithTagGenerationAction;
import dannyandjannymod.CustomTags;

public class OvergrownPower extends AbstractPower {
    public static final String POWER_ID = "OvergrownPower";
    private static final PowerStrings powerStrings;
    public static final String NAME;
    public static final String[] DESCRIPTIONS;

    public OvergrownPower(AbstractCreature owner) {
        this.name = NAME;
        this.ID = "OvergrownPower";
        this.owner = owner;
        this.amount = -1;
        //this.type = PowerType.BUFF;
        this.updateDescription();
        this.loadRegion("barricade");
    }

    public void playApplyPowerSfx() {
        CardCrawlGame.sound.play("POWER_SHACKLE", 0.05F);
    }

    public void updateDescription() {
        this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
    }

    public void atEndOfTurn(boolean isPlayer) {
        if (this.owner.getPower("CalciumPower") != null) {
            int calcAmt = this.owner.getPower("CalciumPower").amount;
            if (calcAmt > 0) {
                this.flash();
                this.addToBot(new GainBlockAction(this.owner, calcAmt, Settings.FAST_MODE));
            }
        }
    }

    static {
        powerStrings = CardCrawlGame.languagePack.getPowerStrings("OvergrownPower");
        //NAME = powerStrings.NAME;
        //DESCRIPTIONS = powerStrings.DESCRIPTIONS;
        NAME = "Overgrown";
        DESCRIPTIONS = new String[] {"At the end of your turn, gain Block equal to your Calcium.", ""} ;
    }
}