package dannyandjannymod.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.watcher.ChangeStanceAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardQueueItem;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.stances.CalmStance;
import dannyandjannymod.AbstractCardEnum;
import dannyandjannymod.CustomTags;
import dannyandjannymod.DrunkAction;
import dannyandjannymod.util.CardInfo;

import java.util.ArrayList;

import static dannyandjannymod.BasicMod.makeID;

public class ChugCard extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "ChugCard",
            0,
            CardType.SKILL,
            CardTarget.NONE,
            CardRarity.SPECIAL,
            AbstractCardEnum.MILKMAN_WHITE);

    public static final String ID = makeID(cardInfo.baseId);


    public ChugCard() {
        super(cardInfo);
        cardsToPreview = new HangoverCard();
        setExhaust(true);
        setMagic(2,1);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        ArrayList<AbstractCard> EligibleCards = new ArrayList();

        for(AbstractCard c : AbstractDungeon.player.hand.group) {
            if (c.cost > 0 && c.costForTurn > 0 && !c.freeToPlayOnce) {
                EligibleCards.add(c);

            }
        }

        for(CardQueueItem i : AbstractDungeon.actionManager.cardQueue) {
            if (i.card != null) {
                EligibleCards.remove(i.card);
            }
        }

        AbstractCard c = null;
        if (!EligibleCards.isEmpty()) {
            c = (AbstractCard)EligibleCards.get(AbstractDungeon.cardRandomRng.random(0, EligibleCards.size() - 1));
        }

        if (c != null) {
            c.setCostForTurn(c.costForTurn - magicNumber);
        }

        addToBot(new DrunkAction());
    }


    @Override
    public AbstractCard makeCopy() { //Optional
        return new ChugCard();
    }
}