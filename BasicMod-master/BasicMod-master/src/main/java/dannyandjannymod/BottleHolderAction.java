//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package dannyandjannymod;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.AbstractGameAction.ActionType;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.tempCards.Shiv;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import dannyandjannymod.cards.EmptyBottleCard;

public class BottleHolderAction extends AbstractGameAction {
    public BottleHolderAction(AbstractCreature source, int amount) {
        this.setValues(this.target, source, amount);
        this.actionType = ActionType.WAIT;
    }

    public void update() {
        int toCreate = this.amount - AbstractDungeon.player.hand.size();
        if (toCreate > 0) {
            this.addToBot(new MakeTempCardInHandAction(new EmptyBottleCard(), toCreate));
        }

        this.isDone = true;

    }
}
