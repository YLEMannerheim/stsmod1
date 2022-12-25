package dannyandjannymod.powers;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardQueueItem;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.ThornsPower;
import dannyandjannymod.CustomTags;

import static dannyandjannymod.BasicMod.makeID;

public class GlassFormPower extends AbstractPower {

    public GlassFormPower(int amount) {
        this.name = "Glass Form";
        this.ID = makeID("Glass Form");
        this.owner = AbstractDungeon.player;
        this.amount = amount;
        this.updateDescription();
        this.loadRegion("demonForm");
    }

    public void updateDescription() {
        description = "Gain X Thorns whenever you lose HP.";
    }

    public int onAttacked(DamageInfo info, int damageAmount) {
        if (damageAmount < this.owner.currentHealth && damageAmount > 0 && info.owner != null && info.type == DamageInfo.DamageType.NORMAL && info.type != DamageInfo.DamageType.HP_LOSS) {
            this.flash();
            this.addToBot(new ApplyPowerAction(this.owner, this.owner, new ThornsPower(this.owner, this.amount), this.amount));
            this.updateDescription();
        }

        return damageAmount;
    }

    /*
    public void stackPower(int stackAmount) {
        this.amount += stackAmount;
        this.basePower += stackAmount;
    }
    */

}