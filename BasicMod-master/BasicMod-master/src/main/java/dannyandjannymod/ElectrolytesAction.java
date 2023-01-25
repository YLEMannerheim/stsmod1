package dannyandjannymod;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.GetAllInBattleInstances;

import java.util.Iterator;
import java.util.UUID;

public class ElectrolytesAction extends AbstractGameAction {

    private AbstractCard toReduce;

    public ElectrolytesAction(AbstractCard toReduce, int reduction)
    {
        this.toReduce = toReduce;
        this.actionType = ActionType.DAMAGE; //prevents being removed by end of combat
        this.amount = reduction;
    }

    public void update() {
        UUID uuid = toReduce.uuid;

        for (AbstractCard c : AbstractDungeon.player.masterDeck.group)
        {
            if (c.uuid.equals(uuid)) {
                c.misc += this.amount;
                c.updateCost(-this.amount);
            }
        }

        for(AbstractCard c : GetAllInBattleInstances.get(uuid)) {
            c.misc += this.amount;
            c.updateCost(-this.amount);
            //c.flash(Color.WHITE.cpy());
        }

        this.isDone = true;
    }
}
