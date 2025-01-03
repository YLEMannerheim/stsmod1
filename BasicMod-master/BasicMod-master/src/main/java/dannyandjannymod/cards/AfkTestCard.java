package dannyandjannymod.cards;

import com.megacrit.cardcrawl.actions.watcher.ChangeStanceAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import dannyandjannymod.AbstractCardEnum;
import dannyandjannymod.stances.AfkStance;
import dannyandjannymod.stances.DepressedStance;
import dannyandjannymod.util.CardInfo;

import static dannyandjannymod.BasicMod.makeID;

public class AfkTestCard extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "AfkTestCard",
            0,
            CardType.SKILL,
            CardTarget.NONE,
            CardRarity.UNCOMMON,
            AbstractCardEnum.MILKMAN_WHITE);

    public static final String ID = makeID(cardInfo.baseId);

    public AfkTestCard() {
        super(cardInfo);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ChangeStanceAction(new AfkStance()));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new AfkTestCard();
    }
}