package dannyandjannymod.cards;

import com.megacrit.cardcrawl.actions.watcher.ChangeStanceAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import dannyandjannymod.AbstractCardEnum;
import dannyandjannymod.stances.AfkStance;
import dannyandjannymod.stances.ChilledStance;
import dannyandjannymod.util.CardInfo;

import static dannyandjannymod.BasicMod.makeID;

public class ChilledTestCard extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "ChilledTestCard",
            0,
            CardType.SKILL,
            CardTarget.NONE,
            CardRarity.UNCOMMON,
            AbstractCardEnum.MILKMAN_WHITE);

    public static final String ID = makeID(cardInfo.baseId);

    public ChilledTestCard() {
        super(cardInfo);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ChangeStanceAction(new ChilledStance()));
    }

    @Override
    public void atTurnStart() {
        super.atTurnStart();
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new ChilledTestCard();
    }
}