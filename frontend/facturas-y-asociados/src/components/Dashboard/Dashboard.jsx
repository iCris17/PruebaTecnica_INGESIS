import { Grid, Typography, createTheme, makeStyles } from "@material-ui/core";
import { purple } from "@material-ui/core/colors";
import { useEffect, useState } from "react";
import TablaFacturas from "./TablaFacturas";

const theme = createTheme({
    palette: {
        primary: purple,
    },
});

const useStyles = makeStyles((theme) => ({
    root: {
        marginTop: "60px",
        height: "100vh",
        display: "flex",
        backgroundColor: "#f5f5f5",
        justifyContent: "center",
        alignItems: "center",
        textAlign: "center",
    },
    container: {
        maxWidth: "85%",
        display: "flex",
        justifyContent: "center",
        alignItems: "center",
        flexDirection: "column",
        "& > *": {
            margin: "10px",
        },
    },
    title: {
        [theme.breakpoints.down("sm")]: {
            fontSize: "24px",
        },
    },
    titleStyles: {
        color: "#802c6e",
    },
}));

function createData(name, calories, fat, carbs, protein) {
    return { name, calories, fat, carbs, protein };
}

const rows = [
    createData("Frozen yoghurt", 159, 6.0, 24, 4.0),
    createData("Ice cream sandwich", 237, 9.0, 37, 4.3),
    createData("Eclair", 262, 16.0, 24, 6.0),
    createData("Cupcake", 305, 3.7, 67, 4.3),
    createData("Gingerbread", 356, 16.0, 49, 3.9),
];

const Dashboard = () => {
    const classes = useStyles();
    const [facturas, setFacturas] = useState();
    const [isDeleted, setIsDeleted] = useState(false);
    const fetchFacturas = () => {
        fetch("http://localhost:8080/factura")
            .then((response) => response.json())
            .then((data) => {
                setFacturas(data.facturasList);
            });
    };
    useEffect(() => {
        fetchFacturas();
    }, [isDeleted]);
    return (
        <>
            <Grid container className={classes.root}>
                <div className={classes.container}>
                    <Typography variant="h4" className={classes.title}>
                        Bienvenido a{" "}
                        <span className={classes.titleStyles}>
                            Facturas & Asociados
                        </span>
                        , acá podrá ver una lista de facturas con una serie de
                        opciones, en las cuales usted decide qué hacer.
                        {facturas && (
                            <TablaFacturas
                                facturas={facturas}
                                fetchFacturas={fetchFacturas}
                                isDeleted={isDeleted}
                                setIsDeleted={setIsDeleted}
                            />
                        )}
                    </Typography>
                </div>
            </Grid>
        </>
    );
};

export default Dashboard;
