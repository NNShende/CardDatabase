package com.example.yugiohcard_domain
@Suppress("unused")
data class YugiohCard(
    val id: String,
    val name: String,
    val type: CardType,
    val desc: String,
    val atk: Int? = null, // Non-null for monsters
    val def: Int? = null, // Non-null for monsters
    val level: Int?  = null, // Non-null for monsters
    val race: CardRace,
    val attribute: String? = null
)

@Suppress("unused")
enum class CardType(name: String) {
    EffectMonster(name = "Effect Monster"),
    FlipEffectMonster(name = "Flip Effect Monster"),
    FlipTunerEffectMonster(name = "Flip Tuner Effect Monster"),
    GeminiMonster(name = "Gemini Monster"),
    NormalMonster(name = "Normal Monster"),
    NormalTunerMonster(name = "Normal Tuner Monster"),
    PendulumEffectMonster(name = "Pendulum Effect Monster"),
    PendulumFlipEffectMonster(name = "Pendulum Flip Effect Monster"),
    PendulumNormalMonster(name = "Pendulum Normal Monster"),
    PendulumTunerEffectMonster(name = "Pendulum Tuner Effect Monster"),
    RitualEffectMonster(name = "Ritual Effect Monster"),
    RitualMonster(name = "Ritual Monster"),
    SkillCard(name = "Skill Card"),
    SpellCard(name = "Spell Card"), // Not a monster
    SpiritMonster(name = "Spirit Monster"),
    ToonMonster(name = "Toon Monster"),
    TrapCard(name = "Trap Card"), // Not a monster
    TunerMonster(name = "Tuner Monster"),
    UnionEffectMonster(name = "Union Effect Monster"),
    FusionMonster(name = "Fusion Monster"),
    LinkMonster(name = "Link Monster"),
    PendulumEffectFusionMonster(name = "Pendulum Effect Fusion Monster"),
    SynchroMonster(name = "Synchro Monster"),
    SynchroPendulumEffectMonster(name = "Synchro Pendulum Effect Monster"),
    SynchroTunerMonster(name = "Synchro Tuner Monster"),
    XYZMonster(name = "XYZ Monster"),
    XYZPendulumEffectMonster(name = "XYZ Pendulum Effect Monster"),
}

@Suppress("unused")
enum class CardRace(name: String) {
    // Monsters
    Aqua("Aqua"),
    Beast("Beast"),
    BeastWarrior("Beast-Warrior"),
    CreatorGod("Creator-God"),
    Cyberse("Cyberse"),
    Dinosaur("Dinosaur"),
    DivineBeast("Divine-Beast"),
    Dragon("Dragon"),
    Fairy("Fairy"),
    Fiend("Fiend"),
    Fish("Fish"),
    Insect("Insect"),
    Machine("Machine"),
    Plant("Plant"),
    Psychic("Psychic"),
    Pyro("Pyro"),
    Reptile("Reptile"),
    Rock("Rock"),
    SeaSerpent("Sea Serpent"),
    Spellcaster("Spellcaster"),
    Thunder("Thunder"),
    Warrior("Warrior"),
    WingedBeast("Winged Beast"),

    // Spell/Trap
    Normal("Normal"), // Both Spell and Trap cards can be this
    Field("Field"),
    Equip("Equip"),
    Continuous("Continuous"), // Both Spell and Trap cards can be this
    QuickPlay("Quick-Play"),
    Ritual("Ritual"),
    Counter("Counter"),
}
