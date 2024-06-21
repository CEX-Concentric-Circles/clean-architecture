Warehouse Management System with Clean Architecture.

Coding Excellence SoSe 2024: https://www.archi-lab.io/regularModules/ss24/cex_ss24.html

### Step 1: Implementation
The following bounded contexts are to be implemented:

1. **InventoryManagement**: A representation of stock levels. Products can be added to or removed from the inventory.
2. **OrderManagement**: Orders are instructions on how stock levels should change. Purchase processing is not implemented.
3. **ProductManagement**: A collection of all goods that can be part of the inventory.

This step serves to determine how much effort, boilerplate code, and overhead is required to implement the respective architectures for very small projects. 
Do the structures of the architecture already influence the analyzability in this step? 
In addition, tests are written for the existing features to continuously test the individual components starting from this step and thus examine the testability of the respective architecture.

### Step 2: Extension
The next step is to determine how complex it is to add new components to the system. To do this, a new bounded context is introduced, for example, a NotificationSystem or VendorManagement. 
The code is then analyzed again as described above. This time, however, the code review is carried out with a focus on the modifiability of the individual code bases.

### Step 3: Extraction
In the final step, a component or bounded context of the system is to be extracted and converted into a standalone component. This is to determine the modularity of the respective architecture. 
As in the first two steps, the code is first analyzed using various tools and then a code review is carried out.

Which bounded contexts, entities, value objects, and aggregates are implemented is determined jointly before the first step. 
Some Domain-Driven Design (DDD) techniques such as event storming or C4 modeling are used for this purpose. 
However, these are only used in a very rudimentary way, as the focus is on the actual implementation of the architectures.