package dannyandjannymod.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.utility.SFXAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.WeakPower;
import com.megacrit.cardcrawl.vfx.combat.IntimidateEffect;
import dannyandjannymod.AbstractCardEnum;
import dannyandjannymod.powers.CalciumPower;
import dannyandjannymod.util.CardInfo;

import java.util.Iterator;

import static dannyandjannymod.BasicMod.makeID;

public class DanCard extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "DanCard",
            1,
            CardType.POWER,
            CardTarget.NONE,
            CardRarity.UNCOMMON,
            AbstractCardEnum.MILKMAN_WHITE);

    public static final String ID = makeID(cardInfo.baseId);

    private static final int MAGIC = 2;

    public DanCard() {
        super(cardInfo);
        setMagic(MAGIC);
        setInnate(false, true);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        Iterator var1 = p.hand.group.iterator();
        AbstractCard c;

        while(var1.hasNext()) {
            c = (AbstractCard)var1.next();
            c.baseDamage += magicNumber;
            c.baseBlock += magicNumber;
            c.superFlash();
            c.applyPowers();
        }
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new DanCard();
    }
}