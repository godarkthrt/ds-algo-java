### LinkedList

1. Find middle node of a linkedlist without using length details

   - use slow and fast pointer technique.
   - every time a slow pointer moves by 1 step the fast pointer moves 2 steps, by the time fast pointer reaches end of Linkedlist slow pointer reaches to the middle node (special attention needs to be paid for what should be returned if even number of nodes are present).
   - **Steps** -
     - point slow and fast pointer to head.
     - while fast is not null and next node of fast is not null.
     - move slow to slow.next and fast to fast.next.next
     - by the time loop ends slow pointer will reach to the middle.

2. Check if LinkedList has a loop.

   - use fast and slow pointer technique.
   - if there is a loop eventually both slow and fast will point to the same node.
   - **Steps** -
   - point slow and fast pointer to head.
   - while fast is not null and next node of fast is not null (fast != null, checks if we have already reached to the end of the list & fast.next != null make sure we can move 2 steps in this iteration rather than getting null pointer ).
   - move slow by 1 step and fast by 2 steps and check if slow and fast ever point to the same node, if yes then there is a loop.
