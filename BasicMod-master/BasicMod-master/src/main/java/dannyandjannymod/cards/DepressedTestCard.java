package dannyandjannymod.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.utility.SFXAction;
import com.megacrit.cardcrawl.actions.watcher.ChangeStanceAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.WeakPower;
import com.megacrit.cardcrawl.vfx.combat.IntimidateEffect;
import dannyandjannymod.AbstractCardEnum;
import dannyandjannymod.powers.CalciumPower;
import dannyandjannymod.stances.DepressedStance;
import dannyandjannymod.util.CardInfo;

import java.util.Iterator;

import static dannyandjannymod.BasicMod.makeID;

public class DepressedTestCard extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "DepressedTestCard",
            0,
            CardType.SKILL,
            CardTarget.NONE,
            CardRarity.UNCOMMON,
            AbstractCardEnum.MILKMAN_WHITE);

    public static final String ID = makeID(cardInfo.baseId);

    public DepressedTestCard() {
        super(cardInfo);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ChangeStanceAction(new DepressedStance()));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new DepressedTestCard();
    }
}