package dannyandjannymod.cards;

import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDrawPileAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import dannyandjannymod.AbstractCardEnum;
import dannyandjannymod.CardWithTagGenerationAction;
import dannyandjannymod.CustomTags;
import dannyandjannymod.util.CardInfo;

import static dannyandjannymod.BasicMod.makeID;

public class LostChildCard extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "LostChildCard",
            1,
            CardType.SKILL,
            CardTarget.NONE,
            CardRarity.SPECIAL,
            CardColor.COLORLESS);

    public static final String ID = makeID(cardInfo.baseId);
    public static final int MAGIC = 1;
    public static final int UPG_MAGIC = 1;


    public LostChildCard() {
        super(cardInfo);
        setMagic(MAGIC, UPG_MAGIC);
        this.cardsToPreview = new RelievedRelativeCard();
        setEthereal(true);
        setExhaust(true);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        for(int i = 0; i < this.magicNumber; i++) {
            AbstractCard c = new RelievedRelativeCard().makeCopy();
            this.addToBot(new MakeTempCardInDrawPileAction(c, 1, true, true));
        }
    }

    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeBaseCost(1);
        }
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new LostChildCard();
    }
}