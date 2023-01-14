package dannyandjannymod.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.HealAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.RegenPower;
import dannyandjannymod.AbstractCardEnum;
import dannyandjannymod.util.CardInfo;

import static dannyandjannymod.BasicMod.makeID;

public class FreshnessCard extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "FreshnessCard",
            1,
            CardType.SKILL,
            CardTarget.NONE,
            CardRarity.UNCOMMON,
            AbstractCardEnum.MILKMAN_WHITE);

    public static final String ID = makeID(cardInfo.baseId);
    public static final int MAGIC = 5;
    public static final int UPG_MAGIC = 2;


    public FreshnessCard() {
        super(cardInfo);
        setMagic(MAGIC, UPG_MAGIC);
        setExhaust(true);
        setEthereal(true);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToBot(new HealAction(p, p, this.magicNumber, 1));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new FreshnessCard();
    }
}