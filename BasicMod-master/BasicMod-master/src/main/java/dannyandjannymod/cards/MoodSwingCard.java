package dannyandjannymod.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.stances.AbstractStance;
import dannyandjannymod.AbstractCardEnum;
import dannyandjannymod.MoodSwingAction;
import dannyandjannymod.RankedgameAction;
import dannyandjannymod.stances.DepressedStance;
import dannyandjannymod.stances.TiltedStance;
import dannyandjannymod.util.CardInfo;

import static dannyandjannymod.BasicMod.makeID;

public class MoodSwingCard extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "MoodSwingCard",
            2,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.COMMON,
            AbstractCardEnum.MILKMAN_WHITE);

    public static final String ID = makeID(cardInfo.baseId);

    private static final int UPG_DAMAGE = 3;
    private static final int DAMAGE = 12;

    public MoodSwingCard() {
        super(cardInfo);
        setDamage(DAMAGE, UPG_DAMAGE);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        int dmg = damage;
        AbstractStance currentStance = p.stance;
        if (currentStance.ID.equals(TiltedStance.STANCE_ID) || currentStance.ID.equals(DepressedStance.STANCE_ID))
            dmg *= 2;
        addToBot(new DamageAction(m, new DamageInfo(p, dmg, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.FIRE));
        addToBot(new MoodSwingAction(currentStance));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new MoodSwingCard();
    }
}