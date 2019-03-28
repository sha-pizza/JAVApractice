# JAVApractice
201901 JAVA프로그래밍실습

→ wow!

---------------------------------------
# 190314 week2 

[2주차 과제 링크](https://github.com/sha-pizza/JAVApractice/tree/master/0314javaprac_w2_animal)

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
# 190321 week3

[3주차 과제 ](https://github.com/sha-pizza/JAVApractice/tree/master/0321javaprac_w3_abstracted)

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
