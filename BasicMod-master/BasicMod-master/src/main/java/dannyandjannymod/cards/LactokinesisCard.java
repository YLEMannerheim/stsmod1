package dannyandjannymod.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.LoseHPAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import dannyandjannymod.util.CardInfo;

import static dannyandjannymod.BasicMod.makeID;

public class LactokinesisCard extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "LactokinesisCard",
            0,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.COMMON,
            CardColor.RED);

    public static final String ID = makeID(cardInfo.baseId);

    private static final int BLOCK = 1;
    private static final int DAMAGE = 1;
    private static final int MAGIC_NUM = 0;
    private static final int UPG_MAGIC_NUM = 1;
    private static final int SELF_DAMAGE = 1;

    public LactokinesisCard() {
        super(cardInfo);
        setDamage(DAMAGE);
        setBlock(BLOCK);
        setMagic(MAGIC_NUM, UPG_MAGIC_NUM);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToBot(new LoseHPAction(p, p, SELF_DAMAGE));
        addToBot(new GainBlockAction(p, p, block));
        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
        this.addToBot(new DrawCardAction(p, magicNumber));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new LactokinesisCard();
    }
}