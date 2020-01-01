// -*-Java-*-
/*!
 * @file  OGMapperSVC_impl.java
 * @brief Service implementation code of MobileRobot.idl
 *
 */
import RTC.OGMapperPOA;
/**
 * OGMapperSVC_impl
 * <p>
 * Example class implementing IDL interface RTC::OGMapper
 */
public class OGMapperSVC_impl extends OGMapperPOA{
    
    public OGMapperSVC_impl() {
        // Please add extra constructor code here.
    }

    /*
     * Methods corresponding to IDL attributes and operations
     */
    public RTC.RETURN_VALUE initializeMap(RTC.OGMapConfig config, RTC.Pose2D initialPose) {
        // Please insert your code here and remove the following warning pragma
        // TODO "Code missing in function <RETURN_VALUE initializeMap(OGMapConfig config, Pose2D initialPose)>"
        return null;
    }

    public RTC.RETURN_VALUE startMapping() {
        // Please insert your code here and remove the following warning pragma
        // TODO "Code missing in function <RETURN_VALUE startMapping()>"
        return null;
    }

    public RTC.RETURN_VALUE stopMapping() {
        // Please insert your code here and remove the following warning pragma
        // TODO "Code missing in function <RETURN_VALUE stopMapping()>"
        return null;
    }

    public RTC.RETURN_VALUE suspendMapping() {
        // Please insert your code here and remove the following warning pragma
        // TODO "Code missing in function <RETURN_VALUE suspendMapping()>"
        return null;
    }

    public RTC.RETURN_VALUE resumeMapping() {
        // Please insert your code here and remove the following warning pragma
        // TODO "Code missing in function <RETURN_VALUE resumeMapping()>"
        return null;
    }

    public RTC.RETURN_VALUE getState(RTC.MAPPER_STATEHolder state) {
        // Please insert your code here and remove the following warning pragma
        // TODO "Code missing in function <RETURN_VALUE getState(MAPPER_STATE state)>"
        return null;
    }

    public RTC.RETURN_VALUE requestCurrentBuiltMap(RTC.OGMapHolder map) {
        // Please insert your code here and remove the following warning pragma
        // TODO "Code missing in function <RETURN_VALUE requestCurrentBuiltMap(OGMap map)>"
        return null;
    }

//  End of example implementational code
}
