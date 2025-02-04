package thomas.library.user.model;

import thomas.library.user.tools.MembershipStrategy;

public class PremiumMembershipStrategy implements MembershipStrategy {
    
    @Override
    public int getMaxBorrowings() {
        return 7;
    }
}