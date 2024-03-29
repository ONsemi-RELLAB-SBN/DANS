package com.onsemi.dans.dao;

import com.onsemi.dans.db.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import com.onsemi.dans.model.EmailTimelapse;
import com.onsemi.dans.tools.QueryResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmailTimelapseDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailTimelapseDAO.class);
    private final Connection conn;
    private final DataSource dataSource;

    public EmailTimelapseDAO() {
        DB db = new DB();
        this.conn = db.getConnection();
        this.dataSource = db.getDataSource();
    }

    public QueryResult insertEmailTimelapse(EmailTimelapse emailTimelapse) {
        QueryResult queryResult = new QueryResult();
        try {
            PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO dans_email_timelapse (send_cc, user_oncid, user_name, email, flag, remarks) VALUES (?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS
            );
            ps.setString(1, emailTimelapse.getSendCc());
            ps.setString(2, emailTimelapse.getUserOncid());
            ps.setString(3, emailTimelapse.getUserName());
            ps.setString(4, emailTimelapse.getEmail());
            ps.setString(5, emailTimelapse.getFlag());
            ps.setString(6, emailTimelapse.getRemarks());
            queryResult.setResult(ps.executeUpdate());
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                queryResult.setGeneratedKey(Integer.toString(rs.getInt(1)));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            queryResult.setErrorMessage(e.getMessage());
            LOGGER.error(e.getMessage());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    LOGGER.error(e.getMessage());
                }
            }
        }
        return queryResult;
    }

    public QueryResult updateEmailTimelapse(EmailTimelapse emailTimelapse) {
        QueryResult queryResult = new QueryResult();
        try {
            PreparedStatement ps = conn.prepareStatement(
                    "UPDATE dans_email_timelapse SET send_cc = ?, user_oncid = ?, user_name = ?, email = ?, flag = ?, remarks = ? WHERE id = ?"
            );
            ps.setString(1, emailTimelapse.getSendCc());
            ps.setString(2, emailTimelapse.getUserOncid());
            ps.setString(3, emailTimelapse.getUserName());
            ps.setString(4, emailTimelapse.getEmail());
            ps.setString(5, emailTimelapse.getFlag());
            ps.setString(6, emailTimelapse.getRemarks());
            ps.setString(7, emailTimelapse.getId());
            queryResult.setResult(ps.executeUpdate());
            ps.close();
        } catch (SQLException e) {
            queryResult.setErrorMessage(e.getMessage());
            LOGGER.error(e.getMessage());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    LOGGER.error(e.getMessage());
                }
            }
        }
        return queryResult;
    }

    public QueryResult deleteEmailTimelapse(String emailTimelapseId) {
        QueryResult queryResult = new QueryResult();
        try {
            PreparedStatement ps = conn.prepareStatement(
                    "DELETE FROM dans_email_timelapse WHERE id = '" + emailTimelapseId + "'"
            );
            queryResult.setResult(ps.executeUpdate());
            ps.close();
        } catch (SQLException e) {
            queryResult.setErrorMessage(e.getMessage());
            LOGGER.error(e.getMessage());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    LOGGER.error(e.getMessage());
                }
            }
        }
        return queryResult;
    }

    public EmailTimelapse getEmailTimelapse(String emailTimelapseId) {
        String sql = "SELECT * FROM dans_email_timelapse WHERE id = '" + emailTimelapseId + "'";
        EmailTimelapse emailTimelapse = null;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                emailTimelapse = new EmailTimelapse();
                emailTimelapse.setId(rs.getString("id"));
                emailTimelapse.setSendCc(rs.getString("send_cc"));
                emailTimelapse.setUserOncid(rs.getString("user_oncid"));
                emailTimelapse.setUserName(rs.getString("user_name"));
                emailTimelapse.setEmail(rs.getString("email"));
                emailTimelapse.setFlag(rs.getString("flag"));
                emailTimelapse.setRemarks(rs.getString("remarks"));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    LOGGER.error(e.getMessage());
                }
            }
        }
        return emailTimelapse;
    }

    public EmailTimelapse getEmailTimelapseWithSelect(String emailTimelapseId, String sendCc) {
        String sql = "SELECT id, send_cc,IF(send_cc=\"" + sendCc + "\",\"selected=''\",\"\") AS selected FROM dans_email_timelapse WHERE id = '" + emailTimelapseId + "'";
        EmailTimelapse emailTimelapse = null;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                emailTimelapse = new EmailTimelapse();
                emailTimelapse.setId(rs.getString("id"));
                emailTimelapse.setSendCc(rs.getString("send_cc"));
                emailTimelapse.setSelect(rs.getString("selected"));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    LOGGER.error(e.getMessage());
                }
            }
        }
        return emailTimelapse;
    }

    public List<EmailTimelapse> getEmailTimelapseList() {
        String sql = "SELECT * FROM dans_email_timelapse ORDER BY id ASC";
        List<EmailTimelapse> emailTimelapseList = new ArrayList<EmailTimelapse>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            EmailTimelapse emailTimelapse;
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                emailTimelapse = new EmailTimelapse();
                emailTimelapse.setId(rs.getString("id"));
                emailTimelapse.setSendCc(rs.getString("send_cc"));
                emailTimelapse.setUserOncid(rs.getString("user_oncid"));
                emailTimelapse.setUserName(rs.getString("user_name"));
                emailTimelapse.setEmail(rs.getString("email"));
                emailTimelapse.setFlag(rs.getString("flag"));
                emailTimelapse.setRemarks(rs.getString("remarks"));
                emailTimelapseList.add(emailTimelapse);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    LOGGER.error(e.getMessage());
                }
            }
        }
        return emailTimelapseList;
    }

    public List<EmailTimelapse> getEmailTimelapseListForCc() {
        String sql = "SELECT * FROM dans_email_timelapse WHERE send_cc = 'Cc' ORDER BY id ASC";
        List<EmailTimelapse> emailTimelapseList = new ArrayList<EmailTimelapse>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            EmailTimelapse emailTimelapse;
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                emailTimelapse = new EmailTimelapse();
                emailTimelapse.setId(rs.getString("id"));
                emailTimelapse.setSendCc(rs.getString("send_cc"));
                emailTimelapse.setUserOncid(rs.getString("user_oncid"));
                emailTimelapse.setUserName(rs.getString("user_name"));
                emailTimelapse.setEmail(rs.getString("email"));
                emailTimelapse.setFlag(rs.getString("flag"));
                emailTimelapse.setRemarks(rs.getString("remarks"));
                emailTimelapseList.add(emailTimelapse);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    LOGGER.error(e.getMessage());
                }
            }
        }
        return emailTimelapseList;
    }

    public List<EmailTimelapse> getEmailTimelapseListForDistList() {
        String sql = "SELECT * FROM dans_email_timelapse WHERE send_cc = 'Dist List' ORDER BY id ASC";
        List<EmailTimelapse> emailTimelapseList = new ArrayList<EmailTimelapse>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            EmailTimelapse emailTimelapse;
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                emailTimelapse = new EmailTimelapse();
                emailTimelapse.setId(rs.getString("id"));
                emailTimelapse.setSendCc(rs.getString("send_cc"));
                emailTimelapse.setUserOncid(rs.getString("user_oncid"));
                emailTimelapse.setUserName(rs.getString("user_name"));
                emailTimelapse.setEmail(rs.getString("email"));
                emailTimelapse.setFlag(rs.getString("flag"));
                emailTimelapse.setRemarks(rs.getString("remarks"));
                emailTimelapseList.add(emailTimelapse);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    LOGGER.error(e.getMessage());
                }
            }
        }
        return emailTimelapseList;
    }

    public Integer getCountName(String userOncid) {
        Integer count = null;
        try {
            PreparedStatement ps = conn.prepareStatement(
                    "SELECT count(*) AS count FROM dans_email_timelapse WHERE user_oncid = '" + userOncid + "'"
            );
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                count = rs.getInt("count");
            }
            rs.close();

            ps.close();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    LOGGER.error(e.getMessage());
                }
            }
        }
        return count;
    }

    public Integer getCountNameWithDifferentID(String id, String userOncid) {
        Integer count = null;
        try {
            PreparedStatement ps = conn.prepareStatement(
                    "SELECT count(*) AS count FROM dans_email_timelapse WHERE user_oncid = '" + userOncid + "' AND id != '" + id + "' "
            );
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                count = rs.getInt("count");
            }
            rs.close();

            ps.close();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    LOGGER.error(e.getMessage());
                }
            }
        }
        return count;
    }

    public Integer getCountCc() {
        Integer count = null;
        try {
            PreparedStatement ps = conn.prepareStatement(
                    "SELECT count(*) AS count FROM dans_email_timelapse WHERE send_cc = 'Cc'"
            );
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                count = rs.getInt("count");
            }
            rs.close();

            ps.close();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    LOGGER.error(e.getMessage());
                }
            }
        }
        return count;
    }
}
