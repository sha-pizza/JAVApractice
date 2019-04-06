# JAVApractice
201901 JAVA프로그래밍실습

--> wow!

---------------------------------------
# 190404 week5

[w5 : GUI](https://github.com/sha-pizza/JAVApractice/tree/master/w5_gui)

**→ GUI**

버튼 3개와 클릭 횟수를 표시하는 GUI를 제작하였습니다. 사이즈는 200*200입니다

**→ review : classmate code**

4월 4일 기준 김찬양님의 레포에 업로드된 Animals 파일들을 읽어 보았습니다! 두 가지 흥미로운 발견을 할 수 있었습니다!

먼저, 저와 inherit structure가 매우 다르게 구성되어 있다는 점이 흥미로웠습니다. 저는 petowner과 vet class를 human class의 서브 클래스로 두고, human class는 animal class의 서브 클래스가 되도록 설정해 두었습니다. 반면에 찬양님의 코드에서 petowner는 어떤 수퍼클래스도 가지지 않으며, buyPet() method를 통해 인스턴스로 가지는 Pets Arraylist에 펫 목록을 저장해두도록 설정해 놓은 것을 확인할 수 있었습니다. 이렇게 같은 이름을 가지고도 이렇게 다른 형태의 클래스 구성이 나올 수 있다는 점이 신기했습니다.

두 번째로는, enhanced for loop를 사용해, for (Animal a:animals) 와 같은 방식으로 Animal Arraylist의 오브젝트들을 불러오신 점도 흥미로웠습니다! 저도 지난 주에 for (Object O : animals) 형태로 코드를 수정하였기 때문에 이런 부분이 눈에 띄었 던 것 같습니다.


---------------------------------------
# 190328 week4 

[forked! openpose](https://github.com/sha-pizza/openpose)

**→ review : fork**

fork 기능은 다른 사람(들)이 제작한 프로젝트를 저의 repository로 가져와서 편집하고, 수정해 볼 수 있도록 지원해줍니다. 

fork기능 없이 download만 가능하게 해 두었더라면 다른 사람의 프로젝트를 로컬 컴퓨터에서만 사용할 수 있었을 것이고 이를 공유하는데에 여러 어려움이 있었을 것 같은데, 바로 본인 github의 repository로 가져올 수 있는 기능을 제공해서 여러 모로 유용하겠다는 생각이 들었습니다.


[w4 : interface](https://github.com/sha-pizza/JAVApractice/tree/master/w4_interface)

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

[w4 : private, getter and setter](https://github.com/sha-pizza/JAVApractice/tree/master/w4_private_getset)

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

[w3 : abstrated code link](https://github.com/sha-pizza/JAVApractice/tree/master/w3_abstracted)

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

[w2 : animal code link](https://github.com/sha-pizza/JAVApractice/tree/master/w2_animal)

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
