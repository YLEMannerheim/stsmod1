package dannyandjannymod.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import dannyandjannymod.powers.CalciumPower;
import dannyandjannymod.util.CardInfo;

import static dannyandjannymod.BasicMod.makeID;

public class KnuckleSandwichCard extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "KnuckleSandwichCard",
            2,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.COMMON,
            CardColor.RED);

    public static final String ID = makeID(cardInfo.baseId);

    private static final int UPG_DAMAGE = 5;
    private static final int DAMAGE = 18;
    private static final int MAGIC = 3;

    public KnuckleSandwichCard() {
        super(cardInfo);
        setDamage(DAMAGE, UPG_DAMAGE);
        setMagic(MAGIC);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_HEAVY));
        addToBot(new ApplyPowerAction(m, p, new CalciumPower(m, this.magicNumber), this.magicNumber));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new KnuckleSandwichCard();
    }
}