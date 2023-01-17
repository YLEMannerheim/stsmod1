package dannyandjannymod.cards;

import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import dannyandjannymod.AbstractCardEnum;
import dannyandjannymod.util.CardInfo;

import static dannyandjannymod.BasicMod.makeID;

public class SpareTireCard extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "SpareTireCard",
            1,
            CardType.SKILL,
            CardTarget.NONE,
            CardRarity.COMMON,
            AbstractCardEnum.MILKMAN_WHITE);

    public static final String ID = makeID(cardInfo.baseId);

    private static final int MAGIC = 2;
    private static final int UPG_MAGIC = 1;

    public SpareTireCard() {
        super(cardInfo);
        setMagic(MAGIC, UPG_MAGIC);
        setSelfRetain(true);
        setExhaust(true);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToBot(new DrawCardAction(p, magicNumber));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new SpareTireCard();
    }
}