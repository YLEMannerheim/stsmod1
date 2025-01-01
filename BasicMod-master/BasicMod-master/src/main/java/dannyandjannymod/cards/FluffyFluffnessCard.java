package dannyandjannymod.cards;

import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.defect.ChannelAction;
import com.megacrit.cardcrawl.actions.watcher.ChangeStanceAction;
import com.megacrit.cardcrawl.actions.watcher.NotStanceCheckAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.vfx.combat.EmptyStanceEffect;
import dannyandjannymod.AbstractCardEnum;
import dannyandjannymod.CustomTags;
import dannyandjannymod.Orbs.PusheenOrb;
import dannyandjannymod.util.CardInfo;

import static dannyandjannymod.BasicMod.makeID;

public class FluffyFluffnessCard extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "FluffyFluffnessCard",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.BASIC,
            AbstractCardEnum.MILKMAN_WHITE);

    public static final String ID = makeID(cardInfo.baseId);

    public FluffyFluffnessCard() {
        super(cardInfo);
        setBlock(8,3);
        this.showEvokeValue = true;
        setMagic(1);
        this.showEvokeOrbCount = 1;
        this.tags.add(CustomTags.CHARACTER);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToBot(new GainBlockAction(p, p, this.block));
        this.addToBot(new ChannelAction(new PusheenOrb()));
        this.addToBot(new NotStanceCheckAction("Neutral", new VFXAction(new EmptyStanceEffect(p.hb.cX, p.hb.cY), 0.1F)));
        this.addToBot(new ChangeStanceAction("Neutral"));

    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new FluffyFluffnessCard();
    }
}