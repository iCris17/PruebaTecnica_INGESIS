import Table from "@material-ui/core/Table";
import TableBody from "@material-ui/core/TableBody";
import TableCell from "@material-ui/core/TableCell";
import TableContainer from "@material-ui/core/TableContainer";
import TableHead from "@material-ui/core/TableHead";
import TableRow from "@material-ui/core/TableRow";
import Paper from "@material-ui/core/Paper";
import { Button, makeStyles } from "@material-ui/core";
import DeleteForeverIcon from "@material-ui/icons/DeleteForever";

const useStyles = makeStyles((theme) => ({
    table: {
        minWidth: "600px",
        maxHeight: "600px",
    },
    deleteButton: {
        background: "red",
        "&:hover": {
            color: "red",
        },
    },
}));

const TablaFacturas = ({
    facturas,
    fetchFacturas,
    isDeleted,
    setIsDeleted,
}) => {
    const classes = useStyles();

    async function handleDelete(idFactura) {
        await fetch(`http://localhost:8080/factura/${idFactura}`, {
            method: "PATCH",
        });

        fetchFacturas();
    }
    return (
        <>
            <TableContainer component={Paper}>
                <Table className={classes.table}>
                    <TableHead>
                        <TableRow>
                            <TableCell>Correlativo</TableCell>
                            <TableCell>Nombre Cliente</TableCell>
                            <TableCell>Fecha</TableCell>
                            <TableCell>Total compra</TableCell>
                            <TableCell align="right">Acciones</TableCell>
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {facturas.map(
                            (factura) =>
                                factura.eliminada === 0 && (
                                    <TableRow key={factura.idFactura}>
                                        <TableCell>
                                            {factura.idFactura},
                                            {console.log(factura.eliminada)}
                                            {factura.eliminada}
                                        </TableCell>
                                        <TableCell>
                                            {factura.nombreCliente}
                                        </TableCell>
                                        <TableCell>{factura.fecha}</TableCell>
                                        <TableCell>{factura.total}</TableCell>
                                        <TableCell align="right">
                                            <Button
                                                className={classes.deleteButton}
                                                onClick={() => {
                                                    handleDelete(
                                                        factura.idFactura
                                                    );
                                                    setIsDeleted(!isDeleted);
                                                }}
                                            >
                                                <DeleteForeverIcon />
                                            </Button>
                                        </TableCell>
                                    </TableRow>
                                )
                        )}
                    </TableBody>
                </Table>
            </TableContainer>
        </>
    );
};

export default TablaFacturas;
