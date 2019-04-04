# JAVApractice
201901 JAVA프로그래밍실습

---------------------------------------
# 190328 week4 

[w4 : interface](https://github.com/sha-pizza/JAVApractice/tree/master/0328javaprac_w4_interface)

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

[w4 : private, getter and setter](https://github.com/sha-pizza/JAVApractice/tree/master/0328javaprac_w4_private_getset)

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

[w3 : abstrated code link](https://github.com/sha-pizza/JAVApractice/tree/master/0321javaprac_w3_abstracted)

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

[w2 : animal code link](https://github.com/sha-pizza/JAVApractice/tree/master/0314javaprac_w2_animal)

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
