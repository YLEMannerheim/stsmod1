package dannyandjannymod.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.DexterityPower;
import dannyandjannymod.CustomTags;
import dannyandjannymod.util.CardInfo;

import static dannyandjannymod.BasicMod.makeID;

public class MilkCoatingCard extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "MilkCoatingCard",
            1,
            CardType.SKILL,
            CardTarget.NONE,
            CardRarity.COMMON,
            CardColor.RED);

    public static final String ID = makeID(cardInfo.baseId);

    private static final int UPG_BLOCK = 3;
    private static final int BLOCK = 9;

    public MilkCoatingCard() {
        super(cardInfo);
        setBlock(BLOCK, UPG_BLOCK);
        setExhaust(true);
        this.tags.add(CustomTags.MILK);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new GainBlockAction(p, p, block));
        this.addToBot(new MakeTempCardInHandAction(new EmptyBottleCard(), 1));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new MilkCoatingCard();
    }
}