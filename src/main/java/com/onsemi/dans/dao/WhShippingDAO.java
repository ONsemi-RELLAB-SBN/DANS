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
import com.onsemi.dans.model.WhShipping;
import com.onsemi.dans.tools.QueryResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WhShippingDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(WhShippingDAO.class);
    private final Connection conn;
    private final DataSource dataSource;

    public WhShippingDAO() {
        DB db = new DB();
        this.conn = db.getConnection();
        this.dataSource = db.getDataSource();
    }

    public QueryResult insertWhShipping(WhShipping whShipping) {
        QueryResult queryResult = new QueryResult();
        try {
            PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO dans_wh_shipping (request_id, mp_no, mp_expiry_date, hardware_barcode_1, date_scan_1, hardware_barcode_2, date_scan_2, shipping_date, status, remarks, flag, created_by, created_date, itempkid, sfpkid, sfpkidB, sfpkidC, sfpkidCtr,sfpkidLc,sfpkidPc) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,NOW(),?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS
            );
            ps.setString(1, whShipping.getRequestId());
            ps.setString(2, whShipping.getMpNo());
            ps.setString(3, whShipping.getMpExpiryDate());
            ps.setString(4, whShipping.getHardwareBarcode1());
            ps.setString(5, whShipping.getDateScan1());
            ps.setString(6, whShipping.getHardwareBarcode2());
            ps.setString(7, whShipping.getDateScan2());
            ps.setString(8, whShipping.getShippingDate());
            ps.setString(9, whShipping.getStatus());
            ps.setString(10, whShipping.getRemarks());
            ps.setString(11, whShipping.getFlag());
            ps.setString(12, whShipping.getCreatedBy());
            ps.setString(13, whShipping.getItempkid());
            ps.setString(14, whShipping.getSfpkid());
            ps.setString(15, whShipping.getSfpkidB());
            ps.setString(16, whShipping.getSfpkidC());
            ps.setString(17, whShipping.getSfpkidCtr());
            ps.setString(18, whShipping.getSfpkidLc());
            ps.setString(19, whShipping.getSfpkidPc());
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

    public QueryResult insertWhShippingLatest(WhShipping whShipping) {
        QueryResult queryResult = new QueryResult();
        try {
            PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO dans_wh_shipping (request_id, box_no, status, flag, change_flag, created_by, created_date, "
                    + "itempkid, sfpkid, sfpkidB, sfpkidC, sfpkidCtr,sfpkidLc,sfpkidPc) VALUES (?,?,?,?,?,?,NOW(),?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS
            );
            ps.setString(1, whShipping.getRequestId());
            ps.setString(2, whShipping.getBoxNo());
            ps.setString(3, whShipping.getStatus());
            ps.setString(4, whShipping.getFlag());
            ps.setString(5, whShipping.getChangeFlag());
            ps.setString(6, whShipping.getCreatedBy());
            ps.setString(7, whShipping.getItempkid());
            ps.setString(8, whShipping.getSfpkid());
            ps.setString(9, whShipping.getSfpkidB());
            ps.setString(10, whShipping.getSfpkidC());
            ps.setString(11, whShipping.getSfpkidCtr());
            ps.setString(12, whShipping.getSfpkidLc());
            ps.setString(13, whShipping.getSfpkidPc());
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

    public QueryResult insertWhShippingEqptFromCsv(WhShipping whShipping) {
        QueryResult queryResult = new QueryResult();
        try {
            PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO dans_wh_shipping (request_id, mp_no, mp_expiry_date, mp_created_date, hardware_barcode_1, "
                    + "date_scan_1, hardware_barcode_2, date_scan_2, shipping_date, inventory_date, status, remarks, "
                    + "flag, created_by, created_date, sfpkid, itempkid, sfpkidB, sfpkidC, sfpkidCtr,sfpkidLc,sfpkidPc) "
                    + "VALUES (?,?,?,NOW(),?,NOW(),?,NOW(),NOW(),NOW(),?,?,?,?,NOW(),?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS
            );
            ps.setString(1, whShipping.getRequestId());
            ps.setString(2, whShipping.getMpNo());
            ps.setString(3, whShipping.getMpExpiryDate());
            ps.setString(4, whShipping.getHardwareBarcode1());
            ps.setString(5, whShipping.getHardwareBarcode2());
            ps.setString(6, whShipping.getStatus());
            ps.setString(7, whShipping.getRemarks());
            ps.setString(8, whShipping.getFlag());
            ps.setString(9, whShipping.getCreatedBy());
            ps.setString(10, whShipping.getSfpkid());
            ps.setString(11, whShipping.getItempkid());
            ps.setString(12, whShipping.getSfpkidB());
            ps.setString(13, whShipping.getSfpkidC());
            ps.setString(14, whShipping.getSfpkidCtr());
            ps.setString(15, whShipping.getSfpkidLc());
            ps.setString(16, whShipping.getSfpkidPc());
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

    public QueryResult updateWhShipping(WhShipping whShipping) {
        QueryResult queryResult = new QueryResult();
        try {
            PreparedStatement ps = conn.prepareStatement(
                    "UPDATE dans_wh_shipping SET request_id = ?, mp_no = ?, mp_expiry_date = ?, hardware_barcode_1 = ?, date_scan_1 = ?, hardware_barcode_2 = ?, date_scan_2 = ?, shipping_date = ?, status = ?, remarks = ?, flag = ?, created_by = ?, modified_by = ?, modified_date = NOW() WHERE id = ?"
            );
            ps.setString(1, whShipping.getRequestId());
            ps.setString(2, whShipping.getMpNo());
            ps.setString(3, whShipping.getMpExpiryDate());
            ps.setString(4, whShipping.getHardwareBarcode1());
            ps.setString(5, whShipping.getDateScan1());
            ps.setString(6, whShipping.getHardwareBarcode2());
            ps.setString(7, whShipping.getDateScan2());
            ps.setString(8, whShipping.getShippingDate());
            ps.setString(9, whShipping.getStatus());
            ps.setString(10, whShipping.getRemarks());
            ps.setString(11, whShipping.getFlag());
            ps.setString(12, whShipping.getCreatedBy());;
            ps.setString(13, whShipping.getModifiedBy());
            ps.setString(14, whShipping.getId());
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

    public QueryResult updateWhShippingStatus(WhShipping whShipping) {
        QueryResult queryResult = new QueryResult();
        try {
            PreparedStatement ps = conn.prepareStatement(
                    "UPDATE dans_wh_shipping SET request_id = ?, status = ?, shipping_date = NOW() WHERE id = ?"
            );
            ps.setString(1, whShipping.getRequestId());
            ps.setString(2, whShipping.getStatus());
            ps.setString(3, whShipping.getId());
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

    public QueryResult updateWhShippingGtsNo(String gtsNo, String whShipId) {
        QueryResult queryResult = new QueryResult();
        try {
            PreparedStatement ps = conn.prepareStatement(
                    "UPDATE dans_wh_shipping SET gts_no = '" + gtsNo + "' WHERE id = '" + whShipId + "'"
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

    public QueryResult updateWhShippingStatusWithItemPkidAndSfpkidAll(WhShipping whShipping) {
        QueryResult queryResult = new QueryResult();
        try {
            PreparedStatement ps = conn.prepareStatement(
                    "UPDATE dans_wh_shipping SET request_id = ?, status = ?, shipping_date = NOW(), sfpkid = ?, sfpkidB = ?, sfpkidC = ?, sfpkidCtr = ?,itempkid = ? WHERE id = ?"
            );
            ps.setString(1, whShipping.getRequestId());
            ps.setString(2, whShipping.getStatus());
            ps.setString(3, whShipping.getSfpkid());
            ps.setString(4, whShipping.getSfpkidB());
            ps.setString(5, whShipping.getSfpkidC());
            ps.setString(6, whShipping.getSfpkidCtr());
            ps.setString(7, whShipping.getItempkid());
            ps.setString(8, whShipping.getId());
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

    public QueryResult updateWhShippingStatusWithItemPkidAndSfpkid(WhShipping whShipping) {
        QueryResult queryResult = new QueryResult();
        try {
            PreparedStatement ps = conn.prepareStatement(
                    "UPDATE dans_wh_shipping SET request_id = ?, status = ?, shipping_date = NOW(), sfpkid = ?, itempkid = ? WHERE id = ?"
            );
            ps.setString(1, whShipping.getRequestId());
            ps.setString(2, whShipping.getStatus());
            ps.setString(3, whShipping.getSfpkid());
            ps.setString(4, whShipping.getItempkid());
            ps.setString(5, whShipping.getId());
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

    public QueryResult updateWhShippingStatusWithItemPkidAndSfpkidLc(WhShipping whShipping) {
        QueryResult queryResult = new QueryResult();
        try {
            PreparedStatement ps = conn.prepareStatement(
                    "UPDATE dans_wh_shipping SET request_id = ?, status = ?, shipping_date = NOW(), sfpkidLc = ?, itempkid = ? WHERE id = ?"
            );
            ps.setString(1, whShipping.getRequestId());
            ps.setString(2, whShipping.getStatus());
            ps.setString(3, whShipping.getSfpkidLc());
            ps.setString(4, whShipping.getItempkid());
            ps.setString(5, whShipping.getId());
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

    public QueryResult updateWhShippingStatusWithItemPkidAndSfpkidPc(WhShipping whShipping) {
        QueryResult queryResult = new QueryResult();
        try {
            PreparedStatement ps = conn.prepareStatement(
                    "UPDATE dans_wh_shipping SET request_id = ?, status = ?, shipping_date = NOW(), sfpkidPc = ?, itempkid = ? WHERE id = ?"
            );
            ps.setString(1, whShipping.getRequestId());
            ps.setString(2, whShipping.getStatus());
            ps.setString(3, whShipping.getSfpkidPc());
            ps.setString(4, whShipping.getItempkid());
            ps.setString(5, whShipping.getId());
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

    public QueryResult updateWhShippingStatusWithSfpkidLcAndSfpkidPc(WhShipping whShipping) {
        QueryResult queryResult = new QueryResult();
        try {
            PreparedStatement ps = conn.prepareStatement(
                    "UPDATE dans_wh_shipping SET request_id = ?, status = ?, shipping_date = NOW(), sfpkidLc = ?, sfpkidPc = ?, itempkid = ? WHERE id = ?"
            );
            ps.setString(1, whShipping.getRequestId());
            ps.setString(2, whShipping.getStatus());
            ps.setString(3, whShipping.getSfpkidLc());
            ps.setString(4, whShipping.getSfpkidPc());
            ps.setString(5, whShipping.getItempkid());
            ps.setString(6, whShipping.getId());
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

    public QueryResult updateWhShippingStatusWithItemPkidAndSfpkidB(WhShipping whShipping) {
        QueryResult queryResult = new QueryResult();
        try {
            PreparedStatement ps = conn.prepareStatement(
                    "UPDATE dans_wh_shipping SET request_id = ?, status = ?, shipping_date = NOW(), sfpkidB = ?, itempkid = ? WHERE id = ?"
            );
            ps.setString(1, whShipping.getRequestId());
            ps.setString(2, whShipping.getStatus());
            ps.setString(3, whShipping.getSfpkidB());
            ps.setString(4, whShipping.getItempkid());
            ps.setString(5, whShipping.getId());
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

    public QueryResult updateWhShippingStatusWithItemPkidAndSfpkidC(WhShipping whShipping) {
        QueryResult queryResult = new QueryResult();
        try {
            PreparedStatement ps = conn.prepareStatement(
                    "UPDATE dans_wh_shipping SET request_id = ?, status = ?, shipping_date = NOW(), sfpkidC = ?, itempkid = ? WHERE id = ?"
            );
            ps.setString(1, whShipping.getRequestId());
            ps.setString(2, whShipping.getStatus());
            ps.setString(3, whShipping.getSfpkidC());
            ps.setString(4, whShipping.getItempkid());
            ps.setString(5, whShipping.getId());
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

    public QueryResult updateWhShippingStatusWithItemPkidAndSfpkidCtr(WhShipping whShipping) {
        QueryResult queryResult = new QueryResult();
        try {
            PreparedStatement ps = conn.prepareStatement(
                    "UPDATE dans_wh_shipping SET request_id = ?, status = ?, shipping_date = NOW(), sfpkidCtr = ?, itempkid = ? WHERE id = ?"
            );
            ps.setString(1, whShipping.getRequestId());
            ps.setString(2, whShipping.getStatus());
            ps.setString(3, whShipping.getSfpkidCtr());
            ps.setString(4, whShipping.getItempkid());
            ps.setString(5, whShipping.getId());
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

    public QueryResult updateWhShippingStatusAndInventoryDate(WhShipping whShipping) {
        QueryResult queryResult = new QueryResult();
        try {
            PreparedStatement ps = conn.prepareStatement(
                    "UPDATE dans_wh_shipping SET request_id = ?, status = ?, flag = ?, inventory_date = NOW() WHERE id = ?"
            );
            ps.setString(1, whShipping.getRequestId());
            ps.setString(2, whShipping.getStatus());
            ps.setString(3, whShipping.getFlag());
            ps.setString(4, whShipping.getId());
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

    public QueryResult updateWhShippingMpNo(WhShipping whShipping) {
        QueryResult queryResult = new QueryResult();
        try {
            PreparedStatement ps = conn.prepareStatement(
                    "UPDATE dans_wh_shipping SET mp_no = ? WHERE id = ?"
            );
            ps.setString(1, whShipping.getMpNo());
            ps.setString(2, whShipping.getId());
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

    public QueryResult updateWhShippingMpExpiryDateWithRequestId(WhShipping whShipping) {
        QueryResult queryResult = new QueryResult();
        try {
            PreparedStatement ps = conn.prepareStatement(
                    "UPDATE dans_wh_shipping SET mp_no = ?, mp_expiry_date = ? WHERE request_id = ?"
            );
            ps.setString(1, whShipping.getMpNo());
            ps.setString(2, whShipping.getMpExpiryDate());
            ps.setString(3, whShipping.getRequestId());
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

    public QueryResult updateWhShippingFlag(WhShipping whShipping) {
        QueryResult queryResult = new QueryResult();
        try {
            PreparedStatement ps = conn.prepareStatement(
                    "UPDATE dans_wh_shipping SET request_id = ?, flag = ? WHERE id = ?"
            );
            ps.setString(1, whShipping.getRequestId());
            ps.setString(2, whShipping.getFlag());
            ps.setString(3, whShipping.getId());
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

    public QueryResult updateWhShippingMp(WhShipping whShipping) {
        QueryResult queryResult = new QueryResult();
        try {
            PreparedStatement ps = conn.prepareStatement(
                    "UPDATE dans_wh_shipping SET mp_no = ?, mp_expiry_date = ?,  status = ?,  modified_by = ?, modified_date = NOW(), mp_created_date = NOW() WHERE id = ?"
            );
            ps.setString(1, whShipping.getMpNo());
            ps.setString(2, whShipping.getMpExpiryDate());
            ps.setString(3, whShipping.getStatus());
            ps.setString(4, whShipping.getModifiedBy());
            ps.setString(5, whShipping.getId());
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

    public QueryResult updateWhShippingTt(WhShipping whShipping) {
        QueryResult queryResult = new QueryResult();
        try {
            PreparedStatement ps = conn.prepareStatement(
                    "UPDATE dans_wh_shipping SET hardware_barcode_1 = ?, date_scan_1 = NOW(), status = ?,  modified_by = ?, modified_date = NOW() WHERE id = ?"
            );
            ps.setString(1, whShipping.getHardwareBarcode1());
            ps.setString(2, whShipping.getStatus());
            ps.setString(3, whShipping.getModifiedBy());
            ps.setString(4, whShipping.getId());
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

    public QueryResult updateWhShippingBs(WhShipping whShipping) {
        QueryResult queryResult = new QueryResult();
        try {
            PreparedStatement ps = conn.prepareStatement(
                    "UPDATE dans_wh_shipping SET hardware_barcode_2 = ?, date_scan_2 = NOW(), status = ?, modified_by = ?, modified_date = NOW() WHERE id = ?"
            );
            ps.setString(1, whShipping.getHardwareBarcode2());
            ps.setString(2, whShipping.getStatus());
            ps.setString(3, whShipping.getModifiedBy());
            ps.setString(4, whShipping.getId());
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

    public QueryResult deleteWhShipping(String whShippingId) {
        QueryResult queryResult = new QueryResult();
        try {
            PreparedStatement ps = conn.prepareStatement(
                    "DELETE FROM dans_wh_shipping WHERE id = '" + whShippingId + "'"
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

    public WhShipping getWhShipping(String whShippingId) {
        String sql = "SELECT * FROM dans_wh_shipping WHERE id = '" + whShippingId + "'";
        WhShipping whShipping = null;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                whShipping = new WhShipping();
                whShipping.setId(rs.getString("id"));
                whShipping.setRequestId(rs.getString("request_id"));
                whShipping.setMpNo(rs.getString("mp_no"));
                whShipping.setMpExpiryDate(rs.getString("mp_expiry_date"));
                whShipping.setHardwareBarcode1(rs.getString("hardware_barcode_1"));
                whShipping.setDateScan1(rs.getString("date_scan_1"));
                whShipping.setHardwareBarcode2(rs.getString("hardware_barcode_2"));
                whShipping.setDateScan2(rs.getString("date_scan_2"));
                whShipping.setShippingDate(rs.getString("shipping_date"));
                whShipping.setStatus(rs.getString("status"));
                whShipping.setRemarks(rs.getString("remarks"));
                whShipping.setFlag(rs.getString("flag"));
                whShipping.setCreatedBy(rs.getString("created_by"));
                whShipping.setCreatedDate(rs.getString("created_date"));
                whShipping.setModifiedBy(rs.getString("modified_by"));
                whShipping.setModifiedDate(rs.getString("modified_date"));
                whShipping.setSfpkid(rs.getString("sfpkid"));
                whShipping.setSfpkidB(rs.getString("sfpkidB"));
                whShipping.setSfpkidC(rs.getString("sfpkidC"));
                whShipping.setSfpkidCtr(rs.getString("sfpkidCtr"));
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
        return whShipping;
    }

    public WhShipping getWhShippingNyRequestId(String requestId) {
        String sql = "SELECT * FROM dans_wh_shipping WHERE request_id = '" + requestId + "'";
        WhShipping whShipping = null;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                whShipping = new WhShipping();
                whShipping.setId(rs.getString("id"));
                whShipping.setRequestId(rs.getString("request_id"));
                whShipping.setMpNo(rs.getString("mp_no"));
                whShipping.setMpExpiryDate(rs.getString("mp_expiry_date"));
                whShipping.setHardwareBarcode1(rs.getString("hardware_barcode_1"));
                whShipping.setDateScan1(rs.getString("date_scan_1"));
                whShipping.setHardwareBarcode2(rs.getString("hardware_barcode_2"));
                whShipping.setDateScan2(rs.getString("date_scan_2"));
                whShipping.setShippingDate(rs.getString("shipping_date"));
                whShipping.setStatus(rs.getString("status"));
                whShipping.setRemarks(rs.getString("remarks"));
                whShipping.setFlag(rs.getString("flag"));
                whShipping.setCreatedBy(rs.getString("created_by"));
                whShipping.setCreatedDate(rs.getString("created_date"));
                whShipping.setModifiedBy(rs.getString("modified_by"));
                whShipping.setModifiedDate(rs.getString("modified_date"));
                whShipping.setSfpkid(rs.getString("sfpkid"));
                whShipping.setSfpkidB(rs.getString("sfpkidB"));
                whShipping.setSfpkidC(rs.getString("sfpkidC"));
                whShipping.setSfpkidCtr(rs.getString("sfpkidCtr"));
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
        return whShipping;
    }

    public WhShipping getWhShippingMergeWithRequest(String whShippingId) {
        String sql = "SELECT sh.*, DATE_FORMAT(sh.mp_expiry_date,'%Y-%m-%d') AS new_mp_expiry_date, re.equipment_type AS equipment_type, "
                + "re.load_card_id AS load_card, re.program_card_id as program_card, re.load_card_qty as load_card_qty,"
                + "re.program_card_qty as program_card_qty, re.sfpkidLc as sfpkidLc, re.sfpkidPc as sfpkidPc,"
                + "re.pcb_a AS pcb_a, re.pcb_a_qty AS pcb_a_qty, re.pcb_b AS pcb_b, re.pcb_b_qty AS pcb_b_qty, re.pcb_c AS pcb_c, re.pcb_c_qty AS pcb_c_qty,re.pcb_ctr AS pcb_ctr, re.pcb_ctr_qty AS pcb_ctr_qty,"
                + "re.equipment_id AS equipment_id, re.quantity AS quantity, re.requested_by AS requested_by, re.requested_date, DATE_FORMAT(re.requested_date,'%d %M %Y') AS view_requested_date "
                + "FROM dans_wh_shipping sh, dans_wh_request re WHERE sh.request_id = re.id AND sh.id = '" + whShippingId + "'";
        WhShipping whShipping = null;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                whShipping = new WhShipping();
                whShipping.setId(rs.getString("id"));
                whShipping.setRequestId(rs.getString("request_id"));
                whShipping.setMpNo(rs.getString("mp_no"));
                whShipping.setMpExpiryDate(rs.getString("new_mp_expiry_date"));
                whShipping.setHardwareBarcode1(rs.getString("hardware_barcode_1"));
                whShipping.setDateScan1(rs.getString("date_scan_1"));
                whShipping.setHardwareBarcode2(rs.getString("hardware_barcode_2"));
                whShipping.setDateScan2(rs.getString("date_scan_2"));
                whShipping.setShippingDate(rs.getString("shipping_date"));
                whShipping.setStatus(rs.getString("status"));
                whShipping.setRemarks(rs.getString("remarks"));
                whShipping.setFlag(rs.getString("flag"));
                whShipping.setCreatedBy(rs.getString("created_by"));
                whShipping.setCreatedDate(rs.getString("created_date"));
                whShipping.setModifiedBy(rs.getString("modified_by"));
                whShipping.setModifiedDate(rs.getString("modified_date"));
                whShipping.setItempkid(rs.getString("itempkid"));
                whShipping.setSfpkid(rs.getString("sfpkid"));
                whShipping.setSfpkidB(rs.getString("sfpkidB"));
                whShipping.setSfpkidC(rs.getString("sfpkidC"));
                whShipping.setSfpkidCtr(rs.getString("sfpkidCtr"));

                //utk display data from table wh_request
                whShipping.setRequestEquipmentType(rs.getString("equipment_type"));
                whShipping.setRequestEquipmentId(rs.getString("equipment_id"));
                whShipping.setPcbA(rs.getString("pcb_a"));
                whShipping.setPcbAQty(rs.getString("pcb_a_qty"));
                whShipping.setPcbB(rs.getString("pcb_b"));
                whShipping.setPcbBQty(rs.getString("pcb_b_qty"));
                whShipping.setPcbC(rs.getString("pcb_c"));
                whShipping.setPcbCQty(rs.getString("pcb_c_qty"));
                whShipping.setPcbCtr(rs.getString("pcb_ctr"));
                whShipping.setPcbCtrQty(rs.getString("pcb_ctr_qty"));
                whShipping.setRequestQuantity(rs.getString("quantity"));
                whShipping.setRequestRequestedBy(rs.getString("requested_by"));
                whShipping.setRequestRequestedDate(rs.getString("requested_date"));
                whShipping.setRequestViewRequestedDate(rs.getString("view_requested_date"));
                whShipping.setLoadCard(rs.getString("load_card"));
                whShipping.setLoadCardQty(rs.getString("load_card_qty"));
                whShipping.setProgramCard(rs.getString("program_card"));
                whShipping.setProgramCardQty(rs.getString("program_card_qty"));
                whShipping.setSfpkidLc(rs.getString("sfpkidLc"));
                whShipping.setSfpkidPc(rs.getString("sfpkidPc"));
                whShipping.setBoxNo(rs.getString("box_no"));
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
        return whShipping;
    }

    public List<WhShipping> getWhShippingList() {
        String sql = "SELECT * FROM dans_wh_shipping ORDER BY id ASC";
        List<WhShipping> whShippingList = new ArrayList<WhShipping>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            WhShipping whShipping;
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                whShipping = new WhShipping();
                whShipping.setId(rs.getString("id"));
                whShipping.setRequestId(rs.getString("request_id"));
                whShipping.setMpNo(rs.getString("mp_no"));
                whShipping.setMpExpiryDate(rs.getString("mp_expiry_date"));
                whShipping.setHardwareBarcode1(rs.getString("hardware_barcode_1"));
                whShipping.setDateScan1(rs.getString("date_scan_1"));
                whShipping.setHardwareBarcode2(rs.getString("hardware_barcode_2"));
                whShipping.setDateScan2(rs.getString("date_scan_2"));
                whShipping.setShippingDate(rs.getString("shipping_date"));
                whShipping.setStatus(rs.getString("status"));
                whShipping.setRemarks(rs.getString("remarks"));
                whShipping.setFlag(rs.getString("flag"));
                whShipping.setCreatedBy(rs.getString("created_by"));
                whShipping.setCreatedDate(rs.getString("created_date"));
                whShipping.setModifiedBy(rs.getString("modified_by"));
                whShipping.setModifiedDate(rs.getString("modified_date"));
                whShipping.setSfpkid(rs.getString("sfpkid"));
                whShipping.setSfpkidB(rs.getString("sfpkidB"));
                whShipping.setSfpkidC(rs.getString("sfpkidC"));
                whShipping.setSfpkidCtr(rs.getString("sfpkidCtr"));
                whShipping.setBoxNo(rs.getString("box_no"));
                whShippingList.add(whShipping);
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
        return whShippingList;
    }

    public List<WhShipping> getWhShippingListMergeWithRequest() {
        String sql = "SELECT sh.*,re.equipment_type AS equipment_type, re.equipment_id AS equipment_id, "
                + "re.pcb_a AS pcb_a, re.pcb_a_qty AS pcb_a_qty, re.pcb_b AS pcb_b, re.pcb_b_qty AS pcb_b_qty, re.pcb_c AS pcb_c, re.pcb_c_qty AS pcb_c_qty,re.pcb_ctr AS pcb_ctr, re.pcb_ctr_qty AS pcb_ctr_qty, "
                + "re.quantity AS quantity,re.requested_by AS requested_by, re.requested_date, DATE_FORMAT(re.requested_date,'%d %M %Y') AS view_requested_date "
                + "FROM dans_wh_shipping sh, dans_wh_request re WHERE sh.request_id = re.id AND sh.flag = '0' ORDER BY id DESC";
        List<WhShipping> whShippingList = new ArrayList<WhShipping>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            WhShipping whShipping;
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                whShipping = new WhShipping();
                whShipping.setId(rs.getString("id"));
                whShipping.setRequestId(rs.getString("request_id"));
                whShipping.setMpNo(rs.getString("mp_no"));
                whShipping.setMpExpiryDate(rs.getString("mp_expiry_date"));
                whShipping.setHardwareBarcode1(rs.getString("hardware_barcode_1"));
                whShipping.setDateScan1(rs.getString("date_scan_1"));
                whShipping.setHardwareBarcode2(rs.getString("hardware_barcode_2"));
                whShipping.setDateScan2(rs.getString("date_scan_2"));
                whShipping.setShippingDate(rs.getString("shipping_date"));
                whShipping.setStatus(rs.getString("status"));
                whShipping.setRemarks(rs.getString("remarks"));
                whShipping.setFlag(rs.getString("flag"));
                whShipping.setCreatedBy(rs.getString("created_by"));
                whShipping.setCreatedDate(rs.getString("created_date"));
                whShipping.setModifiedBy(rs.getString("modified_by"));
                whShipping.setModifiedDate(rs.getString("modified_date"));
                whShipping.setSfpkid(rs.getString("sfpkid"));
                whShipping.setSfpkidB(rs.getString("sfpkidB"));
                whShipping.setSfpkidC(rs.getString("sfpkidC"));
                whShipping.setSfpkidCtr(rs.getString("sfpkidCtr"));
                whShipping.setBoxNo(rs.getString("box_no"));
                whShipping.setGtsNo(rs.getString("gts_no"));

                //utk display data from table wh_request
                whShipping.setRequestEquipmentType(rs.getString("equipment_type"));
                whShipping.setRequestEquipmentId(rs.getString("equipment_id"));
                whShipping.setPcbA(rs.getString("pcb_a"));
                whShipping.setPcbAQty(rs.getString("pcb_a_qty"));
                whShipping.setPcbB(rs.getString("pcb_b"));
                whShipping.setPcbBQty(rs.getString("pcb_b_qty"));
                whShipping.setPcbC(rs.getString("pcb_c"));
                whShipping.setPcbCQty(rs.getString("pcb_c_qty"));
                whShipping.setPcbCtr(rs.getString("pcb_ctr"));
                whShipping.setPcbCtrQty(rs.getString("pcb_ctr_qty"));
                whShipping.setRequestQuantity(rs.getString("quantity"));
                whShipping.setRequestRequestedBy(rs.getString("requested_by"));
                whShipping.setRequestRequestedDate(rs.getString("requested_date"));
                whShipping.setRequestViewRequestedDate(rs.getString("view_requested_date"));

                whShippingList.add(whShipping);
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
        return whShippingList;
    }

    public List<WhShipping> getWhShippingListMergeWithRequestBasedMasterGroupId(String eqptType) {
        String sql = "SELECT sh.*,re.equipment_type AS equipment_type, re.equipment_id AS equipment_id, re.load_card_id AS load_card, re.program_card_id as program_card, re.load_card_qty as load_card_qty,"
                + "re.program_card_qty as program_card_qty, re.sfpkidLc as sfpkidLc, re.sfpkidPc as sfpkidPc, "
                + "re.pcb_a AS pcb_a, re.pcb_a_qty AS pcb_a_qty, re.pcb_b AS pcb_b, re.pcb_b_qty AS pcb_b_qty, re.pcb_c AS pcb_c, re.pcb_c_qty AS pcb_c_qty,re.pcb_ctr AS pcb_ctr, re.pcb_ctr_qty AS pcb_ctr_qty, "
                + "re.quantity AS quantity,re.requested_by AS requested_by, re.requested_date, DATE_FORMAT(re.requested_date,'%d %M %Y') AS view_requested_date "
                + "FROM dans_wh_shipping sh, dans_wh_request re WHERE sh.request_id = re.id AND sh.flag = '0' "
                + "AND re.equipment_type IN (" + eqptType + ") "
                + "ORDER BY id DESC";
        List<WhShipping> whShippingList = new ArrayList<WhShipping>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            WhShipping whShipping;
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                whShipping = new WhShipping();
                whShipping.setId(rs.getString("id"));
                whShipping.setRequestId(rs.getString("request_id"));
                whShipping.setMpNo(rs.getString("mp_no"));
                whShipping.setMpExpiryDate(rs.getString("mp_expiry_date"));
                whShipping.setHardwareBarcode1(rs.getString("hardware_barcode_1"));
                whShipping.setDateScan1(rs.getString("date_scan_1"));
                whShipping.setHardwareBarcode2(rs.getString("hardware_barcode_2"));
                whShipping.setDateScan2(rs.getString("date_scan_2"));
                whShipping.setShippingDate(rs.getString("shipping_date"));
                whShipping.setStatus(rs.getString("status"));
                whShipping.setRemarks(rs.getString("remarks"));
                whShipping.setFlag(rs.getString("flag"));
                whShipping.setCreatedBy(rs.getString("created_by"));
                whShipping.setCreatedDate(rs.getString("created_date"));
                whShipping.setModifiedBy(rs.getString("modified_by"));
                whShipping.setModifiedDate(rs.getString("modified_date"));
                whShipping.setSfpkid(rs.getString("sfpkid"));
                whShipping.setSfpkidB(rs.getString("sfpkidB"));
                whShipping.setSfpkidC(rs.getString("sfpkidC"));
                whShipping.setSfpkidCtr(rs.getString("sfpkidCtr"));
                whShipping.setBoxNo(rs.getString("box_no"));
                whShipping.setGtsNo(rs.getString("gts_no"));

                //utk display data from table wh_request
                whShipping.setRequestEquipmentType(rs.getString("equipment_type"));
                whShipping.setRequestEquipmentId(rs.getString("equipment_id"));
                whShipping.setPcbA(rs.getString("pcb_a"));
                whShipping.setPcbAQty(rs.getString("pcb_a_qty"));
                whShipping.setPcbB(rs.getString("pcb_b"));
                whShipping.setPcbBQty(rs.getString("pcb_b_qty"));
                whShipping.setPcbC(rs.getString("pcb_c"));
                whShipping.setPcbCQty(rs.getString("pcb_c_qty"));
                whShipping.setPcbCtr(rs.getString("pcb_ctr"));
                whShipping.setPcbCtrQty(rs.getString("pcb_ctr_qty"));
                whShipping.setRequestQuantity(rs.getString("quantity"));
                whShipping.setRequestRequestedBy(rs.getString("requested_by"));
                whShipping.setRequestRequestedDate(rs.getString("requested_date"));
                whShipping.setRequestViewRequestedDate(rs.getString("view_requested_date"));
                whShipping.setLoadCard(rs.getString("load_card"));
                whShipping.setLoadCardQty(rs.getString("load_card_qty"));
                whShipping.setProgramCard(rs.getString("program_card"));
                whShipping.setProgramCardQty(rs.getString("program_card_qty"));
                whShipping.setSfpkidLc(rs.getString("sfpkidLc"));
                whShipping.setSfpkidPc(rs.getString("sfpkidPc"));

                whShippingList.add(whShipping);
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
        return whShippingList;
    }

    public WhShipping getWhShippingMergeWithRequestByMpNo(String mpNo) {
        String sql = "SELECT sh.*, DATE_FORMAT(sh.mp_expiry_date,'%Y-%m-%d') AS new_mp_expiry_date, re.equipment_type AS equipment_type, "
                + "re.load_card_id AS load_card, re.program_card_id as program_card, re.load_card_qty as load_card_qty,"
                + "re.program_card_qty as program_card_qty, re.sfpkidLc as sfpkidLc, re.sfpkidPc as sfpkidPc, "
                + "re.pcb_a AS pcb_a, re.pcb_a_qty AS pcb_a_qty, re.pcb_b AS pcb_b, re.pcb_b_qty AS pcb_b_qty, re.pcb_c AS pcb_c, re.pcb_c_qty AS pcb_c_qty,re.pcb_ctr AS pcb_ctr, re.pcb_ctr_qty AS pcb_ctr_qty,"
                + "re.equipment_id AS equipment_id, re.quantity AS quantity, re.requested_by AS requested_by, "
                + "re.requestor_email AS requestor_email, "
                + "re.requested_date, DATE_FORMAT(re.requested_date,'%d %M %Y %h:%i %p') AS view_requested_date "
                + "FROM dans_wh_shipping sh, dans_wh_request re WHERE sh.request_id = re.id AND sh.mp_no = '" + mpNo + "'";
        WhShipping whShipping = null;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                whShipping = new WhShipping();
                whShipping.setId(rs.getString("id"));
                whShipping.setRequestId(rs.getString("request_id"));
                whShipping.setMpNo(rs.getString("mp_no"));
                whShipping.setMpExpiryDate(rs.getString("new_mp_expiry_date"));
                whShipping.setHardwareBarcode1(rs.getString("hardware_barcode_1"));
                whShipping.setDateScan1(rs.getString("date_scan_1"));
                whShipping.setHardwareBarcode2(rs.getString("hardware_barcode_2"));
                whShipping.setDateScan2(rs.getString("date_scan_2"));
                whShipping.setShippingDate(rs.getString("shipping_date"));
                whShipping.setStatus(rs.getString("status"));
                whShipping.setRemarks(rs.getString("remarks"));
                whShipping.setFlag(rs.getString("flag"));
                whShipping.setCreatedBy(rs.getString("created_by"));
                whShipping.setCreatedDate(rs.getString("created_date"));
                whShipping.setModifiedBy(rs.getString("modified_by"));
                whShipping.setModifiedDate(rs.getString("modified_date"));
                whShipping.setSfpkid(rs.getString("sfpkid"));
                whShipping.setSfpkidB(rs.getString("sfpkidB"));
                whShipping.setSfpkidC(rs.getString("sfpkidC"));
                whShipping.setSfpkidCtr(rs.getString("sfpkidCtr"));
                whShipping.setBoxNo(rs.getString("box_no"));
                whShipping.setGtsNo(rs.getString("gts_no"));

                //utk display data from table wh_request
                whShipping.setRequestEquipmentType(rs.getString("equipment_type"));
                whShipping.setRequestEquipmentId(rs.getString("equipment_id"));
                whShipping.setPcbA(rs.getString("pcb_a"));
                whShipping.setPcbAQty(rs.getString("pcb_a_qty"));
                whShipping.setPcbB(rs.getString("pcb_b"));
                whShipping.setPcbBQty(rs.getString("pcb_b_qty"));
                whShipping.setPcbC(rs.getString("pcb_c"));
                whShipping.setPcbCQty(rs.getString("pcb_c_qty"));
                whShipping.setPcbCtr(rs.getString("pcb_ctr"));
                whShipping.setPcbCtrQty(rs.getString("pcb_ctr_qty"));
                whShipping.setRequestQuantity(rs.getString("quantity"));
                whShipping.setRequestRequestedBy(rs.getString("requested_by"));
                whShipping.setRequestRequestorEmail(rs.getString("requestor_email"));
                whShipping.setRequestRequestedDate(rs.getString("requested_date"));
                whShipping.setRequestViewRequestedDate(rs.getString("view_requested_date"));
                whShipping.setLoadCard(rs.getString("load_card"));
                whShipping.setLoadCardQty(rs.getString("load_card_qty"));
                whShipping.setProgramCard(rs.getString("program_card"));
                whShipping.setProgramCardQty(rs.getString("program_card_qty"));
                whShipping.setSfpkidLc(rs.getString("sfpkidLc"));
                whShipping.setSfpkidPc(rs.getString("sfpkidPc"));
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
        return whShipping;
    }

    public WhShipping getWhShippingMergeWithRequestByBoxNo(String boxNo) {
        String sql = "SELECT sh.*, DATE_FORMAT(sh.mp_expiry_date,'%Y-%m-%d') AS new_mp_expiry_date, re.equipment_type AS equipment_type, "
                + "re.load_card_id AS load_card, re.program_card_id as program_card, re.load_card_qty as load_card_qty,"
                + "re.program_card_qty as program_card_qty, re.sfpkidLc as sfpkidLc, re.sfpkidPc as sfpkidPc, "
                + "re.pcb_a AS pcb_a, re.pcb_a_qty AS pcb_a_qty, re.pcb_b AS pcb_b, re.pcb_b_qty AS pcb_b_qty, re.pcb_c AS pcb_c, re.pcb_c_qty AS pcb_c_qty,re.pcb_ctr AS pcb_ctr, re.pcb_ctr_qty AS pcb_ctr_qty,"
                + "re.equipment_id AS equipment_id, re.quantity AS quantity, re.requested_by AS requested_by, "
                + "re.requestor_email AS requestor_email, "
                + "re.requested_date, DATE_FORMAT(re.requested_date,'%d %M %Y %h:%i %p') AS view_requested_date "
                + "FROM dans_wh_shipping sh, dans_wh_request re WHERE sh.request_id = re.id AND sh.box_no = '" + boxNo + "'";
        WhShipping whShipping = null;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                whShipping = new WhShipping();
                whShipping.setId(rs.getString("id"));
                whShipping.setRequestId(rs.getString("request_id"));
                whShipping.setMpNo(rs.getString("mp_no"));
                whShipping.setMpExpiryDate(rs.getString("new_mp_expiry_date"));
                whShipping.setHardwareBarcode1(rs.getString("hardware_barcode_1"));
                whShipping.setDateScan1(rs.getString("date_scan_1"));
                whShipping.setHardwareBarcode2(rs.getString("hardware_barcode_2"));
                whShipping.setDateScan2(rs.getString("date_scan_2"));
                whShipping.setShippingDate(rs.getString("shipping_date"));
                whShipping.setStatus(rs.getString("status"));
                whShipping.setRemarks(rs.getString("remarks"));
                whShipping.setFlag(rs.getString("flag"));
                whShipping.setCreatedBy(rs.getString("created_by"));
                whShipping.setCreatedDate(rs.getString("created_date"));
                whShipping.setModifiedBy(rs.getString("modified_by"));
                whShipping.setModifiedDate(rs.getString("modified_date"));
                whShipping.setSfpkid(rs.getString("sfpkid"));
                whShipping.setSfpkidB(rs.getString("sfpkidB"));
                whShipping.setSfpkidC(rs.getString("sfpkidC"));
                whShipping.setSfpkidCtr(rs.getString("sfpkidCtr"));
                whShipping.setBoxNo(rs.getString("sh.box_no"));
                whShipping.setGtsNo(rs.getString("sh.gts_no"));

                //utk display data from table wh_request
                whShipping.setRequestEquipmentType(rs.getString("equipment_type"));
                whShipping.setRequestEquipmentId(rs.getString("equipment_id"));
                whShipping.setPcbA(rs.getString("pcb_a"));
                whShipping.setPcbAQty(rs.getString("pcb_a_qty"));
                whShipping.setPcbB(rs.getString("pcb_b"));
                whShipping.setPcbBQty(rs.getString("pcb_b_qty"));
                whShipping.setPcbC(rs.getString("pcb_c"));
                whShipping.setPcbCQty(rs.getString("pcb_c_qty"));
                whShipping.setPcbCtr(rs.getString("pcb_ctr"));
                whShipping.setPcbCtrQty(rs.getString("pcb_ctr_qty"));
                whShipping.setRequestQuantity(rs.getString("quantity"));
                whShipping.setRequestRequestedBy(rs.getString("requested_by"));
                whShipping.setRequestRequestorEmail(rs.getString("requestor_email"));
                whShipping.setRequestRequestedDate(rs.getString("requested_date"));
                whShipping.setRequestViewRequestedDate(rs.getString("view_requested_date"));
                whShipping.setLoadCard(rs.getString("load_card"));
                whShipping.setLoadCardQty(rs.getString("load_card_qty"));
                whShipping.setProgramCard(rs.getString("program_card"));
                whShipping.setProgramCardQty(rs.getString("program_card_qty"));
                whShipping.setSfpkidLc(rs.getString("sfpkidLc"));
                whShipping.setSfpkidPc(rs.getString("sfpkidPc"));
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
        return whShipping;
    }

    public Integer getCountMpNo(String mpNo) {
        Integer count = null;
        try {
            PreparedStatement ps = conn.prepareStatement(
                    "SELECT COUNT(*) AS count FROM dans_wh_shipping WHERE mp_no = '" + mpNo + "'"
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

    public Integer getCountMpNoAndNotEqId(String mpNo, String id) {
        Integer count = null;
        try {
            PreparedStatement ps = conn.prepareStatement(
                    "SELECT COUNT(*) AS count FROM dans_wh_shipping WHERE mp_no = '" + mpNo + "' AND id !='" + id + "'"
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

    public Integer getCountMpNoEligbleToShip(String mpNo) {
        Integer count = null;
        try {
            PreparedStatement ps = conn.prepareStatement(
                    //                    "SELECT COUNT(*) AS count FROM cdars_wh_shipping WHERE mp_no = '" + mpNo + "' AND status = 'Verified'" //original 3/11/16
                    //                    "SELECT COUNT(*) AS count FROM cdars_wh_shipping WHERE mp_no = '" + mpNo + "' AND (status = 'Pending Packing List' OR status = 'Pending Shipment to Seremban Factory')" //ass requested 2/11/16
                    "SELECT COUNT(*) AS count FROM dans_wh_shipping WHERE mp_no = '" + mpNo + "' AND status = 'Pending Packing List'" //ass requested 2/11/16
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

    public Integer getCountBoxNoEligbleToShip(String boxNo) {
        Integer count = null;
        try {
            PreparedStatement ps = conn.prepareStatement(
                    //                    "SELECT COUNT(*) AS count FROM cdars_wh_shipping WHERE mp_no = '" + mpNo + "' AND status = 'Verified'" //original 3/11/16
                    //                    "SELECT COUNT(*) AS count FROM cdars_wh_shipping WHERE mp_no = '" + mpNo + "' AND (status = 'Pending Packing List' OR status = 'Pending Shipment to Seremban Factory')" //ass requested 2/11/16
                    //                    "SELECT COUNT(*) AS count FROM cdars_wh_shipping WHERE mp_no = '" + mpNo + "' AND status = 'Pending Packing List'" //ass requested 2/11/16
                    "SELECT COUNT(*) AS count FROM dans_wh_shipping WHERE box_no = '" + boxNo + "' AND status = 'Pending Packing List'" //ass requested 2/11/16

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

    public Integer getCountRequestId(String requestId) {
        Integer count = null;
        try {
            PreparedStatement ps = conn.prepareStatement(
                    "SELECT COUNT(*) AS count FROM dans_wh_shipping WHERE request_id = '" + requestId + "'"
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

    public Integer getCountNoMpNumFlag0() {
        Integer count = null;
        try {
            PreparedStatement ps = conn.prepareStatement(
                    //                    "SELECT COUNT(*) AS count FROM cdars_wh_shipping WHERE status = 'No Material Pass Number' AND flag = '0'" //original 3/11/16
                    "SELECT COUNT(*) AS count FROM dans_wh_shipping WHERE status = 'Pending Material Pass Number' AND flag = '0'" //as requested 2/11/16
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

    public Integer getCountBSFlag0() {
        Integer count = null;
        try {
            PreparedStatement ps = conn.prepareStatement(
                    //                    "SELECT COUNT(*) AS count FROM cdars_wh_shipping WHERE status = 'Not Scan Barcode Sticker Yet' AND flag = '0'" //original 3/11/16
                    "SELECT COUNT(*) AS count FROM dans_wh_shipping WHERE status = 'Pending Box Barcode Scanning' AND flag = '0'" //as requested 2/11/16
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

    public Integer getCountTtFlag0() {
        Integer count = null;
        try {
            PreparedStatement ps = conn.prepareStatement(
                    //                    "SELECT COUNT(*) AS count FROM cdars_wh_shipping WHERE status = 'Not Scan Trip Ticket Yet' AND flag = '0'" //original 3/11/16
                    "SELECT COUNT(*) AS count FROM dans_wh_shipping WHERE status = 'Pending Trip Ticket Scanning' AND flag = '0'" //as requested 2/11/16
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

    public Integer getCountShippedFlag0() {
        Integer count = null;
        try {
            PreparedStatement ps = conn.prepareStatement(
                    //                    "SELECT COUNT(*) AS count FROM cdars_wh_shipping WHERE status = 'Ship' AND flag = '0'" //original
                    "SELECT COUNT(*) AS count FROM dans_wh_shipping WHERE status = 'Pending Shipment to Seremban Factory' AND flag = '0'" //as requested 2/11/16
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

    public WhShipping getWhShippingSfpkidAndItemPkid(String id) {
        String sql = "SELECT sfpkid, sfpkidB, sfpkidC, sfpkidCtr, itempkid, sfpkidLc, sfpkidPc FROM dans_wh_shipping WHERE id = '" + id + "'";
        WhShipping whShipping = null;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                whShipping = new WhShipping();
                whShipping.setSfpkid(rs.getString("sfpkid"));
                whShipping.setSfpkidB(rs.getString("sfpkidB"));
                whShipping.setSfpkidC(rs.getString("sfpkidC"));
                whShipping.setSfpkidCtr(rs.getString("sfpkidCtr"));
                whShipping.setItempkid(rs.getString("itempkid"));
                whShipping.setSfpkidLc(rs.getString("sfpkidLc"));
                whShipping.setSfpkidPc(rs.getString("sfpkidPc"));
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
        return whShipping;
    }

    public QueryResult updateSfpkidAndItemPkid(WhShipping whShipping) {
        QueryResult queryResult = new QueryResult();
        try {
            PreparedStatement ps = conn.prepareStatement(
                    "UPDATE dans_wh_shipping SET sfpkid = ?, itempkid = ? WHERE id = ?"
            );
            ps.setString(1, whShipping.getSfpkid());
            ps.setString(2, whShipping.getItempkid());
            ps.setString(3, whShipping.getId());
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
}
