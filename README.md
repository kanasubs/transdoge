transdoge
==========
Transdoge is an automatic translation companion in Clojure that wraps [microsoft-translator-java-api]
(https://github.com/boatmeme/microsoft-translator-java-api).
<img src="https://i.imgflip.com/dk7q3.jpg"
     alt="arf-arf woof-woof wang-wang hav-hav gong-gong bau-bau vov-vov"
     title="Automatic translation companion doge"
     align="right"
     height="150px"/>

### So install
----------
Add the following to the `:dependencies` vector of your `project.clj` file:
[![clojars version](https://clojars.org/transdoge/latest-version.svg?raw=true)]
(https://clojars.org/transdoge)

### Many usage
----------
`id` and `secret` can be obtained from [datamarket.azure.com/developer/applications](https://datamarket.azure.com/developer/applications)
```clojure
(use 'trans.doge)

; set it in '-main', for example
(set-credentials! :id "app-name"
                  :secret "FrKedrPdaD8iLiaedhsD3iY4+TdYpt95FdFJ9D3zPpU=") ; not my secret

; You need to run this every 10 minutes to get a new authorization token,
; or else translation wont work:
(->token! "app-name" "FrKedrPdaD8iLiaedhsD3iY4+TdYpt95FdFJ9D3zPpU=") ;=>
; "{\"token_type\":\"http://schemas.xmlsoap.org/ws/2009/11/swt-token-profile-1.0\",\"access_token\":\"http%3a%2f%2fschemas.xmlsoap.org%2fws%2f2005%2f05%2fidentity%2fclaims%2fnameidentifier=app-name&http%3a%2f%2fschemas.microsoft.com%2faccesscontrolservice%2f2010%2f07%2fclaims%2fidentityprovider=https%3a%2f%2fdatamarket.accesscontrol.windows.net%2f&Audience=http%3a%2f%2fapi.microsofttranslator.com&ExpiresOn=1416156838&Issuer=https%3a%2f%2fdatamarket.accesscontrol.windows.net%2f&HMACSHA256=%2fLYJay0Cnysu%2bzdB2BDNtaRuA6vwgerTeJwIDPg0O58%3d\",\"expires_in\":\"599\",\"scope\":\"http://api.microsofttranslator.com\"}"

(->langs :FRENCH) ; wow =>
; {:TURC #<Language tr>, :SLOVÈNE #<Language sl>, :FINNOIS #<Language fi>, :INDONÉSIEN #<Language id>, :SLOVAQUE #<Language sk>, :ALLEMAND #<Language de>, :NORVÉGIEN #<Language no>, :DANOIS #<Language da>, :RUSSE #<Language ru>, :ITALIEN #<Language it>, :JAPONAIS #<Language ja>, :TCHÈQUE #<Language cs>, :PORTUGAIS #<Language pt>, :MALAISIEN #<Language ms>, :POLONAIS #<Language pl>, :CORÉEN #<Language ko>, :PERSE #<Language fa>, :BULGARE #<Language bg>, :LITUANIEN #<Language lt>, :AUTO_DETECT #<Language >, :LETTON #<Language lv>, :CHINOIS SIMPLIFIÉ #<Language zh-CHS>, :HINDI #<Language hi>, :HÉBREU #<Language he>, :CHINOIS TRADITIONNEL #<Language zh-CHT>, :URDU #<Language ur>, :HAÏTIEN #<Language ht>, :SUÉDOIS #<Language sv>, :NÉERLANDAIS #<Language nl>, :ESTONIEN #<Language et>, :GREC #<Language el>, :ESPAGNOL #<Language es>, :CATALAN #<Language ca>, :UKRAINIEN #<Language uk>, :THAÏ #<Language th>, :ROUMAIN #<Language ro>, :HMONG DAW #<Language mww>, :FRANÇAIS #<Language fr>, :VIETNAMIEN #<Language vi>, :HONGROIS #<Language hu>, :ARABE #<Language ar>, :ANGLAIS #<Language en>}

(translate "猫" :JAPANESE :PORTUGUESE) ;=> "GATO"

; such language auto-detection
(detect-lang "猫を被る") ;=> #<Language ja>

; such translation with language auto-detection
(translate "ドグドグ" :ENGLISH) ;=> "Dog dog"
```

### Concern?
----------
So scare

### So rich contributions
----------
- [Jonathan Griggs](https://github.com/boatmeme) Author of microsoft-translator-java-api
- [Carlos Cunha](https://github.com/ccfontes) Author of the fork

### There's a license (⌒_⌒;)
----------
Copyright (C) 2015 Carlos C. Fontes.

Licensed under the [Apache License, Version 2.0](https://www.apache.org/licenses/LICENSE-2.0), same as microsoft-translator-java-api.