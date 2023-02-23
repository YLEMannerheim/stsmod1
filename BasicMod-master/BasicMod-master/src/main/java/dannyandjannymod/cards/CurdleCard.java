package dannyandjannymod.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.DexterityPower;
import com.megacrit.cardcrawl.powers.NextTurnBlockPower;
import dannyandjannymod.AbstractCardEnum;
import dannyandjannymod.util.CardInfo;

import static dannyandjannymod.BasicMod.makeID;

public class CurdleCard extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "CurdleCard",
            2,
            CardType.SKILL,
            CardTarget.NONE,
            CardRarity.RARE,
            AbstractCardEnum.MILKMAN_WHITE);

    public static final String ID = makeID(cardInfo.baseId);

    private static final int MAGIC_NUM = 3;
    private static final int BLOCK = 20;
    private static final int UPG_BLOCK = 5;

    public CurdleCard() {
        super(cardInfo);
        setMagic(MAGIC_NUM);
        setBlock(BLOCK, UPG_BLOCK);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new GainBlockAction(p, p, block));
        this.addToBot(new ApplyPowerAction(p, p, new NextTurnBlockPower(p, this.block), this.block));
        this.addToBot(new ApplyPowerAction(p, p, new DexterityPower(p, -this.magicNumber), -this.magicNumber));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new CurdleCard();
    }
}