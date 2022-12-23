package dannyandjannymod.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.DrawCardNextTurnPower;
import dannyandjannymod.util.CardInfo;

import static dannyandjannymod.BasicMod.makeID;

public class GoodNightsRestCard extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "GoodNightsRestCard",
            1,
            CardType.SKILL,
            CardTarget.NONE,
            CardRarity.UNCOMMON,
            CardColor.RED);

    public static final String ID = makeID(cardInfo.baseId);

    private static final int MAGIC = 4;
    private static final int UPG_MAGIC = 1;

    public GoodNightsRestCard() {
        super(cardInfo);
        setMagic(MAGIC, UPG_MAGIC);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToBot(new ApplyPowerAction(p, p, new DrawCardNextTurnPower(p, this.magicNumber), this.magicNumber));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new GoodNightsRestCard();
    }
}