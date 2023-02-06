package dannyandjannymod;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.CardLibrary;
import dannyandjannymod.cards.EmptyBottleCard;

import java.util.ArrayList;
import java.util.Iterator;

import static com.megacrit.cardcrawl.dungeons.AbstractDungeon.*;

public class CardWithTagGenerationAction extends AbstractGameAction {
    public CardWithTagGenerationAction(AbstractCreature source, int amount) {
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

    public static AbstractCard returnRandomCardWithTagInCombat(AbstractCard.CardTags tag) {
        ArrayList<AbstractCard> list = new ArrayList();

        Iterator var2 = CardLibrary.getAllCards().iterator();

        AbstractCard c;
        while(var2.hasNext()) {
            c = (AbstractCard)var2.next();
            if (c.hasTag(tag) && !c.hasTag(AbstractCard.CardTags.HEALING)) {
                list.add(c);
            }
        }

        return (AbstractCard)list.get(cardRandomRng.random(list.size() - 1));

        /*
        ArrayList<AbstractCard> list = new ArrayList();

        Iterator var2 = srcCommonCardPool.group.iterator();

        AbstractCard c;
        while(var2.hasNext()) {
            c = (AbstractCard)var2.next();
            if (c.hasTag(tag) && !c.hasTag(AbstractCard.CardTags.HEALING)) {
                list.add(c);
            }
        }

        var2 = srcUncommonCardPool.group.iterator();

        while(var2.hasNext()) {
            c = (AbstractCard)var2.next();
            if (c.hasTag(tag) && !c.hasTag(AbstractCard.CardTags.HEALING)) {
                list.add(c);
            }
        }

        var2 = srcRareCardPool.group.iterator();

        while(var2.hasNext()) {
            c = (AbstractCard)var2.next();
            if (c.hasTag(tag) && !c.hasTag(AbstractCard.CardTags.HEALING)) {
                list.add(c);
            }
        }

        return (AbstractCard)list.get(cardRandomRng.random(list.size() - 1));
         */
    }
}