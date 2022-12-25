package dannyandjannymod;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.ThornsPower;

public class TrailOfGlassAction extends AbstractGameAction {
    public TrailOfGlassAction(AbstractCreature source, int amount) {
        this.setValues(this.target, source, amount);
        this.actionType = ActionType.WAIT;
    }

    public void update() {
        if (source.getPower("Thorns") != null) {
            int thornsAmt = source.getPower("Thorns").amount;
            if (thornsAmt > 0) {
                addToBot(new GainBlockAction(source, source, thornsAmt));
            }
        }

        this.isDone = true;
    }
}