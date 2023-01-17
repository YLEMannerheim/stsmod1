package dannyandjannymod.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.FrailPower;
import com.megacrit.cardcrawl.powers.IntangiblePlayerPower;
import dannyandjannymod.AbstractCardEnum;
import dannyandjannymod.util.CardInfo;

import static dannyandjannymod.BasicMod.makeID;

public class MissingPersonCard extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "MissingPersonCard",
            2,
            CardType.SKILL,
            CardTarget.NONE,
            CardRarity.RARE,
            AbstractCardEnum.MILKMAN_WHITE);

    public static final String ID = makeID(cardInfo.baseId);


    public MissingPersonCard() {
        super(cardInfo);
        setEthereal(true);
        setExhaust(true);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToBot(new ApplyPowerAction(p, p, new IntangiblePlayerPower(p, this.magicNumber), this.magicNumber));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new MissingPersonCard();
    }
}