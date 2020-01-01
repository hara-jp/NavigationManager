// -*-Java-*-
/*!
 * @file  PathFollowerSVC_impl.java
 * @brief Service implementation code of MobileRobot.idl
 *
 */
import RTC.PathFollowerPOA;
/**
 * PathFollowerSVC_impl
 * <p>
 * Example class implementing IDL interface RTC::PathFollower
 */
public class PathFollowerSVC_impl extends PathFollowerPOA{
    
    public PathFollowerSVC_impl() {
        // Please add extra constructor code here.
    }

    /*
     * Methods corresponding to IDL attributes and operations
     */
    public RTC.RETURN_VALUE followPath(RTC.Path2D path) {
        // Please insert your code here and remove the following warning pragma
        // TODO "Code missing in function <RETURN_VALUE followPath(Path2D path)>"
        return null;
    }

    public RTC.RETURN_VALUE getState(RTC.FOLLOWER_STATEHolder state) {
        // Please insert your code here and remove the following warning pragma
        // TODO "Code missing in function <RETURN_VALUE getState(FOLLOWER_STATE state)>"
        return null;
    }

    public RTC.RETURN_VALUE followPathNonBlock(RTC.Path2D path) {
        // Please insert your code here and remove the following warning pragma
        // TODO "Code missing in function <RETURN_VALUE followPathNonBlock(Path2D path)>"
        return null;
    }

//  End of example implementational code
}
