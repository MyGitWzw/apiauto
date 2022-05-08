package httpclientdemo;

/**
 * @Author: Wzw
 * @Date: 2021/7/31 15:17
 */
public class RegisterParam {
    private String mobilephone;
    private String pwd;

    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getMobilephone() {
        return mobilephone;
    }

    public String getPwd() {
        return pwd;
    }

    @Override
    public String toString() {
        return "RegisterParam{" + "mobilephone='" + mobilephone + '\'' + ", pwd='" + pwd + '\'' + '}';
    }
}
