package dannyandjannymod.cards;

import com.megacrit.cardcrawl.actions.common.GainGoldAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDrawPileAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import dannyandjannymod.AbstractCardEnum;
import dannyandjannymod.util.CardInfo;

import static dannyandjannymod.BasicMod.makeID;

public class RelievedRelativeCard extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "RelievedRelativeCard",
            1,
            CardType.SKILL,
            CardTarget.NONE,
            CardRarity.SPECIAL,
            CardColor.COLORLESS);

    public static final String ID = makeID(cardInfo.baseId);
    public static final int MAGIC = 25;
    public static final int UPG_MAGIC = 5;


    public RelievedRelativeCard() {
        super(cardInfo);
        setMagic(MAGIC, UPG_MAGIC);
        setEthereal(true);
        setExhaust(true);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        CardCrawlGame.sound.play("GOLD_GAIN", 0.1F);
        this.addToBot(new GainGoldAction(this.magicNumber));
    }

    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeBaseCost(1);
        }
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new RelievedRelativeCard();
    }
}