package dannyandjannymod.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.LoseHPAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import dannyandjannymod.AbstractCardEnum;
import dannyandjannymod.util.CardInfo;

import static dannyandjannymod.BasicMod.makeID;

public class ThickSkullCard extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "ThickSkullCard",
            0,
            CardType.SKILL,
            CardTarget.NONE,
            CardRarity.COMMON,
            AbstractCardEnum.MILKMAN_WHITE);

    public static final String ID = makeID(cardInfo.baseId);
    public static final int MAGIC = 6;
    public static final int UPG_MAGIC = 3;
    public static final int BLOCK = 3;
    public static final int UPG_BLOCK = 1;

    public ThickSkullCard() {
        super(cardInfo);
        setMagic(MAGIC, UPG_MAGIC);
        setBlock(BLOCK, UPG_BLOCK);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        int calcAmt = 0;
        if (p.getPower("CalciumPower") != null) {
            calcAmt = p.getPower("CalciumPower").amount;
        }

        if (calcAmt < 1) {
            addToBot(new GainBlockAction(p, p, block));
        } else {
            addToBot(new GainBlockAction(p, p, block + magicNumber));
        }
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new ThickSkullCard();
    }
}