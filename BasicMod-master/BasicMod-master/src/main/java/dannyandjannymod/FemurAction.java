package dannyandjannymod;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.AbstractGameAction.ActionType;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.tempCards.Shiv;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import dannyandjannymod.cards.EmptyBottleCard;

public class FemurAction extends AbstractGameAction {
    public FemurAction(AbstractCreature source, int amount) {
        this.setValues(this.target, source, amount);
        this.actionType = ActionType.WAIT;
    }

    public void update() {
        if (source.getPower("CalciumPower") != null) {
            int calcAmt = source.getPower("CalciumPower").amount;
            this.addToBot(new DrawCardAction(source, calcAmt));
        }

        this.isDone = true;

    }
}