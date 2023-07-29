Feature: Task 2

  Scenario: user can navigate to (ksrtc) Website and book bus
    Given Choose the following from CHIKKAMAGALURU to BENGALURU from the popular routes
    When Choose the arrival date only
    And Click Search for bus
    And Select a seat
    And Choose the boarding point and dropping point
    And Fill the “Customer” and Passenger details
    Then Click on make payment and fill all the fields without submitting the payment