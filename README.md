# JAVApractice
201901 JAVA프로그래밍실습

--> wow!

---------------------------------------
# 190516 week10

[w10 : serializable](https://github.com/sha-pizza/JAVApractice/tree/master/w10serial)

**→ Save Objects**

ObjectOutputStream : Save objects in 1 file

ObjectInputStream  : Load saved objects from file

serial Version UID : Version Control

---------------------------------------
# 190430 Project 1 : Calculator

[P1 : Calculator](https://github.com/sha-pizza/JAVApractice/tree/master/p1calculator)

**→ Project 1 : CALCULATOR**

이미지gui로 작동하는 calculator를 작성하였습니다.

사이즈는 300*500px으로 아래 이미지와 같이 입력버튼과 출력 스크린으로 이루어져 있습니다.

자세한 구조는 [PDF FILE](https://github.com/sha-pizza/JAVApractice/tree/master/p1calculator/w9_2016314216.pdf) 에 있답니다!

<img src="/img/p1img.jpg">

**→ Class Hierarchy**

A_ calculator

B_ Function, GUI, Screen

C_ NumbButton, OperButton, SpecButton

D_ Label

---------------------------------------
# 190411 week6

[w06 : calculatorGUI](https://github.com/sha-pizza/JAVApractice/tree/master/w06gui)

**→ CalculatorGUI**

아래와 같은 형태의 calculator gui를 구성하였습니다.

 <img src="/img/w6calcul.PNG">

**→ Launch EC2 instance**

<img src="/img/w6ec2inst1.PNG" width="50%">

<img src="/img/w6ec2inst2.PNG" width="50%">

---------------------------------------
# 190404 week5

[w05 : GUI](https://github.com/sha-pizza/JAVApractice/tree/master/w05gui)

**→ GUI**

버튼 3개와 클릭 횟수를 표시하는 GUI를 제작하였습니다. 사이즈는 200*200입니다

---------------------------------------
# 190328 week4 

[forked! openpose](https://github.com/sha-pizza/openpose)

**→ review : fork**

fork 기능은 다른 사람(들)이 제작한 프로젝트를 저의 repository로 가져와서 편집하고, 수정해 볼 수 있도록 지원해줍니다. 

fork기능 없이 download만 가능하게 해 두었더라면 다른 사람의 프로젝트를 로컬 컴퓨터에서만 사용할 수 있었을 것이고 이를 공유하는데에 여러 어려움이 있었을 것 같은데, 바로 본인 github의 repository로 가져올 수 있는 기능을 제공해서 여러 모로 유용하겠다는 생각이 들었습니다.


[w04 : interface](https://github.com/sha-pizza/JAVApractice/tree/master/w04interface)

|      super     |   |     classname    |   |        sub        |
|:--------------:|---|:----------------:|---|:-----------------:|
|                |   | A_animalLauncher |   |                   |
|                |   | A_animalFunc     |   |                   |
|                |   | A_animal         | - | B_canine B_feline |
|                |   | A_pet            |   |                   |
|                |   | A_robot          |   |                   |
| A_animal       | - | B_canine         | - | C_dog C_wolf      |
| A_animal       | - | B_feline         | - | C_cat C_tiger     |
| B_feline A_pet | - | C_cat            |   |                   |
| B_canine A_pet | - | C_dog            |   |                   |
| A_pet A_robot  | - | C_robodog        |   |                   |
| B_feline       | - | C_tiger          |   |                   |
| B_canine       | - | C_wolf           |   |                   |

[w04 : private, getter and setter](https://github.com/sha-pizza/JAVApractice/tree/master/w04privategetset)

|      A_super     | private                         |    |   B_mid  |    | C_sub   |
|:----------------:|---------------------------------|----|:--------:|----|---------|
| A_animalLauncher | ,                               |    |          |    |         |
| A_animalFunc     | ,                               |    |          |    |         |
| A_animal         | private food, getter and setter | -> | B_canine | -> | C_dog   |
|                  |                                 |    |          | -> | C_wolf  |
|                  |                                 | -> | B_feline | -> | C_cat   |
|                  |                                 |    |          | -> | C_tiger |

---------------------------------------
# 190321 week3

[w03 : abstrated code link](https://github.com/sha-pizza/JAVApractice/tree/master/w03abstracted)

→ abstract, interface

→ with animal class

→ (ab) means abstracted class

**→ inherit structure**

| superclass       |    | <->          |    | subclass   |
|------------------|----|--------------|----|------------|
| A_               |    | B_           |    | C_         |
| A_animalLauncher |    |              |    |            |
| A_animalFunc     |    |              |    |            |
| (ab)A_animal     | -> | (ab)B_human  | -> | C_vet      |
|                  |    |              | -> | C_PetOwner |
|                  | -> | (ab)B_feline | -> | C_tiger    |
|                  |    |              | -> | C_cat      |
|                  | -> | (ab)B_Canine | -> | C_wolf     |
|                  |    |              | -> | C_Dog      |
|                  | -> | -----------> | -> | C_hippo    |

---------------------------------------
# 190314 week2 

[w02 : animal code link](https://github.com/sha-pizza/JAVApractice/tree/master/w02animal)

→ inheritance, polymorphism

→ with animal class

**→ inherit structure**

| superclass       |    | <->      |    | subclass   |
|------------------|----|----------|----|------------|
| A_               |    | B_       |    | C_         |
| A_animalLauncher |    |          |    |            |
| A_animal         | -> | B_human  | -> | C_vet      |
|                  |    |          | -> | C_PetOwner |
|                  | -> | B_feline | -> | C_tiger    |
|                  |    |          | -> | C_cat      |
|                  | -> | B_Canine | -> | C_wolf     |
|                  |    |          | -> | C_Dog      |
|                  | -> | -------> | -> | C_hippo    |



---------------------------------------
