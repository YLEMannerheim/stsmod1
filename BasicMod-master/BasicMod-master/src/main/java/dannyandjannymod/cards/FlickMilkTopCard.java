package dannyandjannymod.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.FlickMilkTopPower;
import dannyandjannymod.AbstractCardEnum;
import dannyandjannymod.powers.FlickMilkTopUpgradedPower;
import dannyandjannymod.util.CardInfo;

import static dannyandjannymod.BasicMod.makeID;

public class FlickMilkTopCard extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "FlickMilkTopCard",
            0,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.COMMON,
            AbstractCardEnum.MILKMAN_WHITE);

    public static final String ID = makeID(cardInfo.baseId);

    private static final int UPG_DAMAGE = 5;
    private static final int DAMAGE = 3;

    public FlickMilkTopCard() {
        super(cardInfo);
        setDamage(DAMAGE, UPG_DAMAGE);
        setExhaust(true);
        //this.shuffleBackIntoDrawPile = true;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(
                m,
                p,
                upgraded ? new FlickMilkTopUpgradedPower(m) : new FlickMilkTopPower(m)));
        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new FlickMilkTopCard();
    }
}