// -*-Java-*-
/*!
 * @file  PathPlannerSVC_impl.java
 * @brief Service implementation code of MobileRobot.idl
 *
 */
import RTC.PathPlannerPOA;
/**
 * PathPlannerSVC_impl
 * <p>
 * Example class implementing IDL interface RTC::PathPlanner
 */
public class PathPlannerSVC_impl extends PathPlannerPOA{
    
    public PathPlannerSVC_impl() {
        // Please add extra constructor code here.
    }

    /*
     * Methods corresponding to IDL attributes and operations
     */
    public RTC.RETURN_VALUE planPath(RTC.PathPlanParameter param, RTC.Path2DHolder outPath) {
        // Please insert your code here and remove the following warning pragma
        // TODO "Code missing in function <RETURN_VALUE planPath(PathPlanParameter param, Path2D outPath)>"
        return null;
    }

//  End of example implementational code
}
