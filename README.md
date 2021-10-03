"# oop-2021-uto-16-c-krizan-steboee" 
CTIBOR KOVALČÍK
# CKT - Service - System

Spoločnosť CKT - Service je firma ktorá ponúka širokú škálu ECU (softvérových)  úprav
rôznych automobilov.

# V CKT - Service pracujú zamestnanci s rôznymi úlohami.

# ZAMESTNANCI:

1. Správca skladu
2. Mechanik
3. Elektromechanik 

**Mechanik**- Keď do servisu príde nové auto, mechanik najprv spíše záznam (rôzne údaje: Kw na brzde , toč
mom. ...) o vozidle. Následne auto odíde k elektromechanikovi ... Po aplikovnaí softwarevoých úprav sa auto vráti späť k 
mechanikovi a ten to auto otestuje druhý krát aktualizuje záznam o vozidle(Kw, Hp , Nm auta po úpravách)

**Elektromechanik** - Elektromechanik má za úlohu autu priradiť súčiastku, ktorú vyberie podľa stropnej ceny objednávky 
a takisto aj vyberie aký typ doplnkovej výbavy si zákazník požiadal.

**Správca objednávok** - Správca objednávok spravuje objednávky ktoré prešli cez mechanika aj druhý krát. Má možnosť vrátiť objednávku naspäť mechanikovi aby auto otestoval odznova alebo môže vytvoriť Faktúru danej objednávke.


**Postup pri spustení aplikácie**

**Zakaznik**
Na úvodnej obrazovke sa zobrazí jednoduchý login, v prípade že uživateľ ešte nieje zaregistrovaný tak stlačí tlačidlo REGISTER a v novom okne vyplní údaje a prihlasovacie údaje. Po registrácií sa uživateľ može prihlásiť. Má na výber 2 možnosti: 
1. Vytvoriť objednávku
2. Prezrieť svoje objednávky

JEDEN ZAAKZNIK SI MOZE ZADAT VIAC OBJEDNAVOK NA JEHO MENO


**1**
Tu si zákazník može vytvoriť objednávku, dáta v choiceboxoch sa menia na základe výberu Znacky/ Paliva auta...
Zákazník vyplní stropnú cenu za ktorú si chce auto vylepšiť.


**2**
V tomto okno si zakaznik može skontrolovať svoje objednávky a ( IN PROGRESS : pozrie si záznam o vozidle čo sa pridalo , aké zmeny boli vykonané, a može si pozrieť aj faktúru ak je obejdnávka vybavená






**Zamestnanec**

Vo firme sú momentálne 3 zamestnanci(budú viacerí).
Každý druh zamestnanca má vlastné prihlasovacie údaje

**Mechanik** --------

Mechanik može vytvoriť prvotný záznam vozidla, ak tak urobí tak daná objednávka sa zmeni z "Neotvorená" na "U Elektromechanika" 
a mechanik teraz nemože s daným záznamom nič robiť až dokým elektromechanik nevyberie pre dané auto nejaké upravy


**meno**: mechanik
**heslo**: m1234

**Elektromechanik**--------
Elektromechanik vyberá pre danú objednávku nejakú softwérovú upravu a vyberie aj ČIP

**meno**: elektromechanik
**heslo**: e1234

**Správca objednávok**--------
 Správca má pristup k obejdnávkam ktoré už boli 2-hý krát u mechanika a mechanik to dané auto otestoval uŽ aj po úpravách.
 može vytvoriť faktúru ---> V PROCESE

**meno**: spravca
**heslo**: s1234



**---------------------------------------------------------------------------------------**

PO PREZENTÁCIÍ:

Po prezentovaní som v projekte nič neupravoval, jedine komentáre ku kódu + javodoc commments.. prípadné nepatrné zmeny v kóde (mazanie nepotrebného)





Projekt som realizoval v IntelIJ ale skúsil som to vyexportovať do prostredie Eclipse (neskúšal som to spustiť v eclipse ale v IntelIJ to funguje na 100%) .


