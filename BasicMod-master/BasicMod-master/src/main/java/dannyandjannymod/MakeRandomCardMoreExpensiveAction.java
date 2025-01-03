package dannyandjannymod;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

import java.util.ArrayList;

public class MakeRandomCardMoreExpensiveAction extends AbstractGameAction {
    AbstractPlayer p;
    public MakeRandomCardMoreExpensiveAction() {
        this.actionType = ActionType.CARD_MANIPULATION;
        this.p = AbstractDungeon.player;
        this.duration = Settings.ACTION_DUR_FAST;
    }

    public void update() {
        ArrayList<AbstractCard> cardsInHand = new ArrayList<>(p.hand.group);

        AbstractCard c = null;
        if (!cardsInHand.isEmpty())
            c = (AbstractCard)cardsInHand.get(AbstractDungeon.cardRandomRng.random(0, cardsInHand.size() - 1));

        if (c != null)
            c.setCostForTurn(c.costForTurn + 1);

        this.isDone = true;
    }
}