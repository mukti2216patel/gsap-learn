#include <iostream>
using namespace std;

// Define a structure for a Coach
struct Coach {
    int Coach_no;
    int Seats;
    int Reward;
    Coach* next;  // Pointer to the next coach

    Coach(int no, int s, int r) : Coach_no(no), Seats(s), Reward(r), next(nullptr) {}
};

// Function to handle reward (deleting two coaches after current)
void handleReward(Coach* &train, Coach* currentCoach) {
     if (currentCoach == nullptr || currentCoach->next == nullptr || currentCoach->next->next == nullptr) {
        cout << "Cannot delete two coaches after the current coach." << endl;
        return;
    }

    // Remove two coaches after the current coach
    Coach* toDelete1 = currentCoach->next;           // First coach to be deleted
    Coach* toDelete2 = currentCoach->next->next;     // Second coach to be deleted

    currentCoach->next = toDelete2->next;            // Link the current coach to the coach after the second one

    // Deleting the coaches
    delete toDelete1;
    delete toDelete2;

}

// Function to handle punishment (adding two coaches after current)
void handlePunishment(Coach* &train, Coach* currentCoach) {
    Coach* newCoach1 = new Coach(currentCoach->Coach_no + 1, 50, 0);
    Coach* newCoach2 = new Coach(currentCoach->Coach_no + 2, 50, 0);
    
    newCoach1->next = newCoach2;  // Link the new coaches together
    currentCoach->next = newCoach1; // Link the current coach to the first new coach
}

int main() {
    // Initialize train with coaches
    Coach* train = new Coach(1, 30, 0);
    train->next = new Coach(2, 40, 0);
    train->next->next = new Coach(3, 50, 1);  // Coach with reward
    train->next->next->next = new Coach(4, 60, 0);

    // Print initial coaches in the train
    Coach* current = train;
    cout << "Initial train coaches:" << endl;
    while (current != nullptr) {
        cout << "Coach No: " << current->Coach_no << ", Seats: " << current->Seats << ", Reward: " << current->Reward << endl;
        current = current->next;
    }

    // Simulate reward scenario (delete two coaches)
    cout << "\nAfter reward (deleting two coaches):" << endl;
    handleReward(train, train->next->next);  // Assume the person is at Coach 3

    // Print coaches after reward
    current = train;
    while (current != nullptr) {
        cout << "Coach No: " << current->Coach_no << ", Seats: " << current->Seats << ", Reward: " << current->Reward << endl;
        current = current->next;
    }

    // Simulate punishment scenario (add two new coaches)
    cout << "\nAfter punishment (adding two new coaches):" << endl;
    handlePunishment(train, train->next->next);  // Assume the person is at Coach 3

    // Print coaches after punishment
    current = train;
    while (current != nullptr) {
        cout << "Coach No: " << current->Coach_no << ", Seats: " << current->Seats << ", Reward: " << current->Reward << endl;
        current = current->next;
    }

    return 0;
}
