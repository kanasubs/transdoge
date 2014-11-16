transdoge
==========
<img src="https://i.imgflip.com/dk7q3.jpg"
     alt="arf-arf woof-woof wang-wang hav-hav gong-gong bau-bau vov-vov"
     title="Automatic translation companion doge"
     align="left" />

Transdoge is an automatic translation companion in Clojure that wraps [microsoft-translator-java-api]
(https://github.com/boatmeme/microsoft-translator-java-api).

### So install
----------
Add the following to the `:dependencies` vector of your `project.clj` file:
[![clojars version](https://clojars.org/transdoge/latest-version.svg?raw=true)]
(https://clojars.org/transdoge)

### Many usage
----------
.. and shooting them to selected targets:
```clj
(use 'trans.doge)

; set it in '-main', for example
(set-credentials! :id "app-name" ; link
                  :secret "FrKedrPdaD8iLiaedhsD3iY4+TdYpt95FdFJ9D3zPpU=")

; wow
(->langs :FRENCH)
;=>
;{:TURC #<Language tr>, :SLOVÈNE #<Language sl>, :FINNOIS #<Language fi>, :INDONÉSIEN #<Language id>, :SLOVAQUE #<Language sk>, :ALLEMAND #<Language de>, :NORVÉGIEN #<Language no>, :DANOIS #<Language da>, :RUSSE #<Language ru>, :ITALIEN #<Language it>, :JAPONAIS #<Language ja>, :TCHÈQUE #<Language cs>, :PORTUGAIS #<Language pt>, :MALAISIEN #<Language ms>, :POLONAIS #<Language pl>, :CORÉEN #<Language ko>, :PERSE #<Language fa>, :BULGARE #<Language bg>, :LITUANIEN #<Language lt>, :AUTO_DETECT #<Language >, :LETTON #<Language lv>, :CHINOIS SIMPLIFIÉ #<Language zh-CHS>, :HINDI #<Language hi>, :HÉBREU #<Language he>, :CHINOIS TRADITIONNEL #<Language zh-CHT>, :URDU #<Language ur>, :HAÏTIEN #<Language ht>, :SUÉDOIS #<Language sv>, :NÉERLANDAIS #<Language nl>, :ESTONIEN #<Language et>, :GREC #<Language el>, :ESPAGNOL #<Language es>, :CATALAN #<Language ca>, :UKRAINIEN #<Language uk>, :THAÏ #<Language th>, :ROUMAIN #<Language ro>, :HMONG DAW #<Language mww>, :FRANÇAIS #<Language fr>, :VIETNAMIEN #<Language vi>, :HONGROIS #<Language hu>, :ARABE #<Language ar>, :ANGLAIS #<Language en>}

(translate "猫" :JAPANESE :PORTUGUESE) ;=> "GATO"

; such language auto-detection
(translate "ドグドグ" :ENGLISH) ;=> "Dog dog"
```

### Concern?
----------
So scare

### Much transdoge use? Wow, put it here!
----------
[kanasubs.com](http://www.kanasubs.com) — Convert raw subtitles in Kanji to
Kana online.

### So rich contributions
----------
- [Jonathan Griggs](https://github.com/boatmeme) Author of microsoft-translator-java-api
- [Carlos Cunha](https://github.com/ccfontes) Author of the fork

### There's a license (⌒_⌒;)
----------
Copyright (C) 2014 Carlos C. Fontes.

Licensed under the ["Apache License, Version 2.0"]("https://www.apache.org/licenses/LICENSE-2.0"), same as microsoft-translator-java-api.